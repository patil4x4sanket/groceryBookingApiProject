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
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> updateGroceryItem(@RequestHeader Map<String, String> headerMap, @RequestBody GroceryItem groceryItem) {
        return groceryServices.updateGrocery(groceryItem);
    }



    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGrocery(@PathVariable("id") int id) {
        return groceryServices.getGrocery(id);
    }


    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return groceryServices.getAllGroceries();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteGroceryItem(@RequestHeader Map<String, String> headerMap, @PathVariable("id") int id) {
        return groceryServices.deleteGrocery(id);
    }

    @PostMapping("/book")
    public ResponseEntity<Map<String, String>> bookItems(@RequestHeader Map<String, String> headerMap, @RequestBody BookedGroceryItems bookedGroceryItemId) {
        return groceryServices.bookGroceries(headerMap.get(USER_NAME), bookedGroceryItemId);
    }

}

