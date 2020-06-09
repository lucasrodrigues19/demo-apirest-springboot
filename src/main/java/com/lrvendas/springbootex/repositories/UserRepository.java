package com.lrvendas.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrvendas.springbootex.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
