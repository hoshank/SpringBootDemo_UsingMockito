package com.bl.demo.controller;

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

    @PostMapping("/add")
    public User addUser(@RequestBody UserDto user) {
        System.out.println("hello " + user.userName);
        return userService.addUser(user);
    }
    @PutMapping("/update")
    public String login( @RequestBody UserDto user) {
        return userService.updateUser(user);
    }
}
