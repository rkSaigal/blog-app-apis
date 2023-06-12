package com.codewithraj.blog.blogappapis.repository;

import com.codewithraj.blog.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {


    Optional<User> findByEmail(String email);
}
