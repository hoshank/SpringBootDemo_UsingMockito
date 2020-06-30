package com.bl.demo.controller;
/***
 *
 * Purpose:Login And Register user
 * Author:Palak
 * Date:28/06/20
 */

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.Response;
import com.bl.demo.model.User;
import com.bl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/register")
    public ResponseEntity<Response> registerResponse(@Valid @RequestBody UserDto user, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.ALREADY_REPORTED);
        User user1 = userService.registerUser(user);
        Response response = new Response("Register successful", user1, 101);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *
     * @param userDto accepts user input
     * @return string notification
     */
    @PostMapping("/login")
    public ResponseEntity<Response> loginResponse(@RequestBody UserDto userDto) {
        Optional<User> loginUser = userService.loginUser(userDto);
        Response response = new Response("Login successful", loginUser, 101);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}