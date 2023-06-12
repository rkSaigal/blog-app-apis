package com.codewithraj.blog.blogappapis.payloads;

import com.codewithraj.blog.blogappapis.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4,message = "Username must be min of 4 character")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min = 3,max=10,message = "Password must be min of 3 char and max of 10 chars !!")
    //@Pattern()
    private String password;
    @NotNull
    private String about;

    private Set<RoleDto> roles=new HashSet<>();
}
