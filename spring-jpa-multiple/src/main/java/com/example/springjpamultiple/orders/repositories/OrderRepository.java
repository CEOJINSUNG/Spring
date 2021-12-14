package com.example.springjpamultiple.orders.repositories;

import com.example.springjpamultiple.orders.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
