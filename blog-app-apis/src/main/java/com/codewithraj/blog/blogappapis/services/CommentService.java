package com.codewithraj.blog.blogappapis.services;

import com.codewithraj.blog.blogappapis.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);
}
