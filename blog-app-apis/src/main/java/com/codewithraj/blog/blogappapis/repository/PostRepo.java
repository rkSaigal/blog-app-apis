package com.codewithraj.blog.blogappapis.repository;

import com.codewithraj.blog.blogappapis.entities.Category;
import com.codewithraj.blog.blogappapis.entities.Post;
import com.codewithraj.blog.blogappapis.entities.User;
//import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    //List<Post> findByTitleContaining(String title);

    @Query("select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);

}
