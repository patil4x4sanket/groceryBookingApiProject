package com.patil.sanket.groceryBookingApiProject.repositories;

import com.patil.sanket.groceryBookingApiProject.beans.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> { }
