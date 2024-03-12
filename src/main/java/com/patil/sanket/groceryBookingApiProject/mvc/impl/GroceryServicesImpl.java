package com.patil.sanket.groceryBookingApiProject.mvc.impl;

import com.patil.sanket.groceryBookingApiProject.beans.BookedGroceryItems;
import com.patil.sanket.groceryBookingApiProject.beans.GroceryItem;
import com.patil.sanket.groceryBookingApiProject.beans.Order;
import com.patil.sanket.groceryBookingApiProject.beans.User;
import com.patil.sanket.groceryBookingApiProject.repositories.GroceriesRepository;
import com.patil.sanket.groceryBookingApiProject.repositories.OrdersRepository;
import com.patil.sanket.groceryBookingApiProject.repositories.UsersRepository;
import com.patil.sanket.groceryBookingApiProject.mvc.services.GroceryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.patil.sanket.groceryBookingApiProject.common.Constants.ERROR_MESSAGE;
import static com.patil.sanket.groceryBookingApiProject.common.Constants.STATUS;

@Service
public class GroceryServicesImpl implements GroceryServices {

    @Autowired
    private GroceriesRepository groceriesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public ResponseEntity<Map<String, String>> addGrocery(GroceryItem groceryItem) {
        // save or saveAndFlush() : internally is checks if the given object with the id is already present in repositories or not, if presents it merges the changes else, it adds new
        Map<String, String> responseMap = new HashMap<>();
        try {
            GroceryItem addedGroceryItem = groceriesRepository.saveAndFlush(groceryItem);
            responseMap.put(STATUS, "Addition of Grocery Item is successful");
            responseMap.put("added_item", addedGroceryItem.toString());
            return ResponseEntity.ok(responseMap);
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            responseMap.put(STATUS, "Failed to Add Grocery Item : " + groceryItem);
            responseMap.put(ERROR_MESSAGE, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }
    @Override
    public ResponseEntity<Map<String, String>> updateGrocery(GroceryItem groceryItem) {
        Map<String, String> responseMap = new HashMap<>();
        try {
            GroceryItem updatedGroceryItem = groceriesRepository.save(groceryItem);
            responseMap.put(STATUS, "Updation of Grocery Item is successful");
            responseMap.put("updated_item", updatedGroceryItem.toString());
            return ResponseEntity.ok(responseMap);
        }catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            responseMap.put(STATUS, "Failed to Add Grocery Item : " + groceryItem);
            responseMap.put(ERROR_MESSAGE, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> deleteGrocery(int gId) {
        Map<String, String> responseMap = new HashMap<>();
        try {
            Optional<GroceryItem> groceryItemOptional = groceriesRepository.findById(gId);
            if(groceryItemOptional.isPresent()) {
                groceriesRepository.deleteById(gId);
                responseMap.put(STATUS, "Deletion of Grocery Item with id = " + gId + " is successful");
                responseMap.put("deleted_item", groceryItemOptional.get().toString());
                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put(STATUS, "Deletion of Grocery Item with id = " + gId + " is unsuccessful");
                responseMap.put(ERROR_MESSAGE, "Grocery Item with id = " + gId + " does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            responseMap.put(STATUS, "Failed to Delete the Grocery Item with id = " + gId);
            responseMap.put(ERROR_MESSAGE, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }

    @Override
    public ResponseEntity<GroceryItem> getGrocery(int gId) {
        try {
            Optional<GroceryItem> groceryItemOptional = groceriesRepository.findById(gId);
            if(groceryItemOptional.isPresent()) {
                GroceryItem groceryItem = groceryItemOptional.orElse(null);
                return ResponseEntity.ok().body(groceryItem);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        List<GroceryItem> groceryItemList = groceriesRepository.findAll();
        return ResponseEntity.ok().body(groceryItemList);
    }


    @Override
    public ResponseEntity<Map<String, String>> bookGroceries(String username, BookedGroceryItems bookedGroceryItems) {
        Map<Integer, Integer> groceryItemIds = bookedGroceryItems.getBookedItems();
        Map<String, String> responseMap = new HashMap<>();
        Set<String> bookedGroceryItemSet = new HashSet<>();
        try {
            User user = usersRepository.findByuName(username);
            float totalAmount = 0;
            for (Map.Entry<Integer, Integer> bookedGroceryItemAndQuantityEntry : groceryItemIds.entrySet()) {
                Optional<GroceryItem> groceryItemOptional = groceriesRepository.findById(bookedGroceryItemAndQuantityEntry.getKey());
                if (groceryItemOptional.isPresent()) {
                    GroceryItem groceryItem = groceryItemOptional.get();
                    int bookedQuantity = bookedGroceryItemAndQuantityEntry.getValue();
                    // updating the quantity of the items, assuming grocery store has atleast 1 item present in the repositories
                    groceryItem.setgQuantity(groceryItem.getgQuantity() - bookedQuantity);
                    groceryItem = groceriesRepository.save(groceryItem);

                    // saving the order in order table
                    ordersRepository.save(new Order(user, groceryItem, bookedQuantity));
                    float totalPrice = groceryItem.getgPrice() * bookedQuantity;
                    totalAmount += totalPrice;
                    bookedGroceryItemSet.add(groceryItem.toStringWithBookedQuantity(bookedQuantity, totalPrice));
                }
            }
            responseMap.put(STATUS, "Items Booked Successfully");
            responseMap.put("booked_items", bookedGroceryItemSet.toString());
            responseMap.put("total_amount_of_booked_items", String.valueOf(totalAmount));
            return ResponseEntity.ok(responseMap);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            responseMap.put(STATUS, "Failed to Book Items");
            responseMap.put(ERROR_MESSAGE, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }

    @Override
    public String getRole(String userName) {
        User user = usersRepository.findByuName(userName);
        return user.getuRole();
    }

}
