package com.codewithraj.blog.blogappapis.controllers;

import com.codewithraj.blog.blogappapis.entities.User;
import com.codewithraj.blog.blogappapis.exception.ApiException;
import com.codewithraj.blog.blogappapis.payloads.JwtAuthRequest;
import com.codewithraj.blog.blogappapis.payloads.JwtAuthResponse;
import com.codewithraj.blog.blogappapis.payloads.UserDto;
import com.codewithraj.blog.blogappapis.security.JwtTokenHelper;
import com.codewithraj.blog.blogappapis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request) throws Exception {

        this.authenticate(request.getUsername(),request.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.jwtTokenHelper.generateToken(userDetails);

       JwtAuthResponse response=new JwtAuthResponse();
       response.setToken(token);
     //  response.setUser(this.modelMapper.map((User) userDetails, UserDto.class));

      // response.setUser();
       return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username,String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);

       try{
           this.authenticationManager.authenticate(authenticationToken);
       }catch (BadCredentialsException e){
           System.out.println("Invalid Details !!");
           throw new ApiException("Invalid username or password !!");
       }

    }

    //Register new user api

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){

        UserDto registeredUser = this.userService.registerNewUser(userDto);

        return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
    }

}
