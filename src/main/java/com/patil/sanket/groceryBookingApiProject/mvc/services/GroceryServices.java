package com.patil.sanket.groceryBookingApiProject.mvc.services;

import com.patil.sanket.groceryBookingApiProject.beans.BookedGroceryItems;
import com.patil.sanket.groceryBookingApiProject.beans.GroceryItem;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GroceryServices {
    public ResponseEntity<Map<String, String>> addGrocery(GroceryItem groceryItem);
    public ResponseEntity<Map<String, String>> updateGrocery(GroceryItem groceryItem);
    public ResponseEntity<Map<String, String>> deleteGrocery(int gId);
    public ResponseEntity<GroceryItem> getGrocery(int gId);
    public ResponseEntity<List<GroceryItem>> getAllGroceries();

    public ResponseEntity<Map<String, String>> bookGroceries(String username, BookedGroceryItems bookedGroceryItems);

    public String getRole(String userName);
}
