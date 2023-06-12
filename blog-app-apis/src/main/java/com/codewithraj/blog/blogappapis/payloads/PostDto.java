package com.codewithraj.blog.blogappapis.payloads;

import com.codewithraj.blog.blogappapis.entities.Category;
import com.codewithraj.blog.blogappapis.entities.Comment;
import com.codewithraj.blog.blogappapis.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor


public class PostDto {



    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments=new HashSet<>();


}
