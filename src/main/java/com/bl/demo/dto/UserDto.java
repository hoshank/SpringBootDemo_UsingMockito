package com.bl.demo.dto;

/**
 * purpose:takes the input from controller and is passed to service layer
 */
public class UserDto {

    public String userName;
    public String password;

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}