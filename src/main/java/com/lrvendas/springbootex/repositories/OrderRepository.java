package com.lrvendas.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrvendas.springbootex.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
