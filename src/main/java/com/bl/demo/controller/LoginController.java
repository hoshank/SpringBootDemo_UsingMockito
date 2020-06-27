package com.bl.demo.controller;
/**
 * Purpose:Login And Register user
 * Author:Plk
 */

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.Response;
import com.bl.demo.model.User;
import com.bl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    IUserService userService;

    /**
     *
     * @param user details
     * @return adding user in database
     */
    @PostMapping("/add")
    public User addUser(@RequestBody UserDto user) {
        System.out.println("hello " + user.userName);
        return userService.registerUser(user);
    }

    /**
     *
     * @param userDto accepts user input
     * @return string notification
     */
    @PostMapping("/login")
    public ResponseEntity<Response> loginResponse(@RequestBody UserDto user) {
        Optional<User> loginUser = userService.loginUser(user);
        Response response = new Response("Login successful", loginUser, 101);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
