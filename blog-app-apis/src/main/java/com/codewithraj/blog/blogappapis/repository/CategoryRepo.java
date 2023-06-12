package com.codewithraj.blog.blogappapis.repository;

import com.codewithraj.blog.blogappapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {


}
