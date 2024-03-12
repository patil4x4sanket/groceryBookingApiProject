package com.patil.sanket.groceryBookingApiProject.repositories;

import com.patil.sanket.groceryBookingApiProject.beans.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceriesRepository extends JpaRepository<GroceryItem, Integer> { }
