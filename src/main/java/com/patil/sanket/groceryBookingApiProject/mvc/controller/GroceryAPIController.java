package com.patil.sanket.groceryBookingApiProject.mvc.controller;

import com.patil.sanket.groceryBookingApiProject.beans.BookedGroceryItems;
import com.patil.sanket.groceryBookingApiProject.beans.GroceryItem;
import com.patil.sanket.groceryBookingApiProject.mvc.services.GroceryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.patil.sanket.groceryBookingApiProject.common.Constants.USER_NAME;


@RestController
@RequestMapping("/v1/grocery")
public class GroceryAPIController {

    @Autowired
    private GroceryServices groceryServices;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> addGroceryItem(@RequestHeader Map<String, String> headerMap, @RequestBody GroceryItem groceryItem) {

        return groceryServices.addGrocery(groceryItem);

//        String userName = headerMap.get(USER_NAME);
//        Map<String, String> responseMap = new LinkedHashMap<>();
//        if(!CommonMethods.isEmpty(userName)) {
//            String role = groceryServices.getRole(userName);
//            if(!CommonMethods.isEmpty(role)) {
//                if (ROLE_USER.equalsIgnoreCase(role)) {
//                    responseMap.put(ERROR_MESSAGE, String.format(ACCESS_DENIED_MESSAGE, userName, ADD_OPERATION));
//                    return ResponseEntity.status(403).body(responseMap);
//                }
//                GroceryItem addedGrocery = groceryServices.addGrocery(groceryItem);
//                responseMap.put(STATUS, "Addition of Grocery Item is successful");
//                responseMap.put("added_item", addedGrocery.toString());
//                return ResponseEntity.ok(responseMap);
//            } else {
//                responseMap.put(STATUS, "Addition of Grocery Item is unsuccessful");
//                responseMap.put(ERROR_MESSAGE, "user " + userName + " is not found");
//                return ResponseEntity.badRequest().body(responseMap);
//            }
//        } else {
//            responseMap.put(STATUS, "Addition of Grocery Item is unsuccessful");
//            responseMap.put(ERROR_MESSAGE, "User Name is not provided");
//            return ResponseEntity.badRequest().body(responseMap);
//        }
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> updateGroceryItem(@RequestHeader Map<String, String> headerMap, @RequestBody GroceryItem groceryItem) {

        return groceryServices.updateGrocery(groceryItem);

//        String userName = headerMap.get(USER_NAME);
//        String role = groceryServices.getRole(userName);
//        Map<String, String> responseMap = new LinkedHashMap<>();
//        if(ROLE_USER.equalsIgnoreCase(role)) {
//            responseMap.put(ERROR_MESSAGE, String.format(ACCESS_DENIED_MESSAGE, userName, UPDATE_OPERATION));
//            return ResponseEntity.status(403).body(responseMap);
//        }
//        GroceryItem updatedGrocery = groceryServices.updateGrocery(groceryItem);
//        responseMap.put(STATUS, "Updation of Grocery Item is successful");
//        responseMap.put("updated_item", updatedGrocery.toString());
//        return ResponseEntity.ok(responseMap);
    }



    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGrocery(@PathVariable("id") int id) {
        return groceryServices.getGrocery(id);
//        return ResponseEntity.ok(groceryServices.getGrocery(id));
    }


    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return groceryServices.getAllGroceries();
//        return ResponseEntity.ok(groceryServices.getAllGroceries());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteGroceryItem(@RequestHeader Map<String, String> headerMap, @PathVariable("id") int id) {

        return groceryServices.deleteGrocery(id);

//        String userName = headerMap.get(USER_NAME);
//        String role = groceryServices.getRole(userName);
//        Map<String, String> responseMap = new LinkedHashMap<>();
//        if(ROLE_USER.equalsIgnoreCase(role)) {
//            responseMap.put(ERROR_MESSAGE, String.format(ACCESS_DENIED_MESSAGE, userName, DELETE_OPERATION));
//            return ResponseEntity.status(403).body(responseMap);
//        }
//        GroceryItem groceryItem = groceryServices.getGrocery(id);
//        if(groceryItem != null) {
//            groceryServices.deleteGrocery(id);
//            responseMap.put(STATUS, "Deletion of Grocery Item Id = " + id + " is successful");
//            responseMap.put("deleted_item", groceryItem.toString());
//            return ResponseEntity.ok(responseMap);
//        } else {
//            responseMap.put(STATUS, "Deletion of Grocery Item Id = " + id + " is unsuccessful");
//            responseMap.put(ERROR_MESSAGE, "Grocery Item with id = " + id + ", is not found");
//            return ResponseEntity.badRequest().body(responseMap);
//        }
    }

    @PostMapping("/book")
    public ResponseEntity<Map<String, String>> bookItems(@RequestHeader Map<String, String> headerMap, @RequestBody BookedGroceryItems bookedGroceryItemId) {

        return groceryServices.bookGroceries(headerMap.get(USER_NAME), bookedGroceryItemId);

//        String userName = headerMap.get(USER_NAME);
//        Map<String, String> responseMap = new LinkedHashMap<>();
//        if(!CommonMethods.isEmpty(userName)) {
//            String role = groceryServices.getRole(userName);
//            if(!CommonMethods.isEmpty(role)) {
//                // apart from user role, no one else can book the grocery item
//                if (!ROLE_USER.equalsIgnoreCase(role)) {
//                    responseMap.put(ERROR_MESSAGE, String.format(ACCESS_DENIED_MESSAGE, userName, BOOK_OPERATION));
//                    return ResponseEntity.status(403).body(responseMap);
//                }
//                List<String> bookedGrocery = new ArrayList<>();
//                for(int id : bookedGroceryItemId.getIds()) {
//                    GroceryItem groceryItem = groceryServices.getGrocery(id);
//                    if(groceryItem != null && groceryItem.getgQuantity() > 0) {
//                        groceryItem.setgQuantity(groceryItem.getgQuantity() - 1);
//                        bookedGrocery.add(groceryServices.updateGrocery(groceryItem).toStringWithoutQuantity());
//                    }
//                }
//                responseMap.put(STATUS, "Booking successful");
//                responseMap.put("booked_items", bookedGrocery.toString());
//                return ResponseEntity.ok().body(responseMap);
//            } else {
//                responseMap.put(STATUS, "Booking of Grocery Item is unsuccessful");
//                responseMap.put(ERROR_MESSAGE, "user " + userName + " is not found");
//                return ResponseEntity.badRequest().body(responseMap);
//            }
//        } else {
//            responseMap.put(STATUS, "Booking of Grocery Item is unsuccessful");
//            responseMap.put(ERROR_MESSAGE, "User Name is not provided");
//            return ResponseEntity.badRequest().body(responseMap);
//        }
    }

}

