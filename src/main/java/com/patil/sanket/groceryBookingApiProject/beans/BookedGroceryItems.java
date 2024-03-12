package com.patil.sanket.groceryBookingApiProject.beans;

import java.util.Map;

public class BookedGroceryItems {
    private Map<Integer, Integer> bookedItems;


    public BookedGroceryItems() {
    }

    public BookedGroceryItems(Map<Integer, Integer> bookedItems) {
        this.bookedItems = bookedItems;
    }


    public Map<Integer, Integer> getBookedItems() {
        return bookedItems;
    }

    public void setBookedItems(Map<Integer, Integer> bookedItems) {
        this.bookedItems = bookedItems;
    }

    @Override
    public String toString() {
        return "BookedGroceryItems{" +
                "ids=" + this.bookedItems +
                '}';
    }
}
