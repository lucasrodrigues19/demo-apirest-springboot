package com.lrvendas.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrvendas.springbootex.entites.Category;
import com.lrvendas.springbootex.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
