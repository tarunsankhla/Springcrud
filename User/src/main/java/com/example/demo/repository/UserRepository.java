package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.User;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository <User, Long> { 
    List<User> findByName(String name); 
}


