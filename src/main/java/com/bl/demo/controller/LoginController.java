package com.bl.demo.controller;
/**
 * Purpose:Login And Register user
 * Author:Plk
 */

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;
import com.bl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/update")
    public String login( @RequestBody UserDto userDto) {
        return userService.loginUser(userDto);
    }
}
