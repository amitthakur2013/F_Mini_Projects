package com.wings1.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wings1.assignment.models.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
