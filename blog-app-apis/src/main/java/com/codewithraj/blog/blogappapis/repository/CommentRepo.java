package com.codewithraj.blog.blogappapis.repository;

import com.codewithraj.blog.blogappapis.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
