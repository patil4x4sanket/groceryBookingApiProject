package com.patil.sanket.groceryBookingApiProject.repositories;

import com.patil.sanket.groceryBookingApiProject.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    public User findByuName(String uName);
}
