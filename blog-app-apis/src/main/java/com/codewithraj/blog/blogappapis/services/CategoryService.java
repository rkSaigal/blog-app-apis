package com.codewithraj.blog.blogappapis.services;

import com.codewithraj.blog.blogappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //CREATE
    public CategoryDto createCategory(CategoryDto categoryDto);

    //UPDATE
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //DELETE
    public void deleteCategory(Integer categoryId);

    //GET
    public CategoryDto getCategory(Integer categoryId);

    //GET ALL
    List<CategoryDto> getCategories();


}
