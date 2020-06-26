package com.bl.demo;
/**
 * purpose:mock the repository layer that the service is dependant on.
 */

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;
import com.bl.demo.repository.UserRepository;
import com.bl.demo.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceMockitoTest {
    @Mock
    UserRepository repository;
    @Autowired
    IUserService userService;

    UserDto userDTO;
    List<User> userList = new ArrayList<>();


    @Test
    void contextLoads() {
    }

    /**
     * purpose: validate successfull login
     */
    @Test
    public void givenRequest_WhenGetResponse_ShouldReturnUserDetailsList() {
        userDTO = new UserDto("plk", "pwd");
        when(repository.save(any())).thenReturn(new User());
        String msg = userService.loginUser(userDTO);
        Assert.assertEquals("Login successfull", msg);
    }
    /**
     * purpose: validate wrong credentials
     */
    @Test
    public void givenRequestToAddUser_ShouldAddUser(){
        userDTO=new UserDto("Palakk","plk@16");
        User user = new User(userDTO);
        userList.add(user);
        when(repository.save(user)).thenReturn(user);
        User addUser = userService.registerUser(userDTO);
        Assert.assertEquals(user.getUserName(),addUser.getUserName());
    }
}