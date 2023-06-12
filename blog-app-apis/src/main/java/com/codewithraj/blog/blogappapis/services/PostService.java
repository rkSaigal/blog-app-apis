package com.codewithraj.blog.blogappapis.services;

import com.codewithraj.blog.blogappapis.entities.Post;
import com.codewithraj.blog.blogappapis.payloads.PostDto;
import com.codewithraj.blog.blogappapis.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all post

   // List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
    PostResponse getAllPost(Integer pageumber,Integer pageSize,String sortBy,String sortDir);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category

    List<PostDto> getPostsByCategory(Integer categoryId);


    //get all posts by user

    List<PostDto> getPostsByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keyword);
}
