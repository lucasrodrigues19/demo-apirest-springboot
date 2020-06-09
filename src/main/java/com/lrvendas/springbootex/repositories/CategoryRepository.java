package com.lrvendas.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrvendas.springbootex.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
