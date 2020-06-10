package com.lrvendas.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrvendas.springbootex.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
