package com.bl.demo.dto;

import javax.validation.constraints.NotEmpty;

/**
 * purpose:takes the input from controller and is passed to service layer
 */
public class UserDto {
    @NotEmpty(message = "mandatory fields")
    public String userName;
    @NotEmpty(message = "mandatory fields")
    public String password;

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}