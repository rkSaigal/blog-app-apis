package com.codewithraj.blog.blogappapis.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {

    private String token;
    private UserDto user;
}
