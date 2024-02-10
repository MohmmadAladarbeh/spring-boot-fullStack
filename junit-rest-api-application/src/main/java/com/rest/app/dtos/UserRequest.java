package com.rest.app.dtos;

import com.rest.app.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private Set<UserRole> roles;
}

//----------------------------

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class UserResponse {
    private Long id;
    private String username;
    private Set<UserRole> roles;
}