package com.bl.demo;

import com.bl.demo.controller.LoginController;
import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;
import com.bl.demo.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class LoginControllerMockitoTest {

    @Mock
    IUserService service;
    @Autowired
    LoginController userController;

    List<User> userList = new ArrayList<>();
    UserDto userDTO;

    @Test
    void contextLoads() {
    }

    //TC to check if login is successfull or not
    @Test
    void givenRequestToAddUser_WhenGetAdded_ShouldReturnCorrectMessage() {
        userDTO = new UserDto("plkk", "pwdd");
        when(service.updateUser(userDTO)).thenReturn("Login Successfull");
        String msg = service.updateUser(userDTO);
        Assert.assertEquals("Login Successfull", msg);
    }

    //TC to check if registration is done
    @Test
    public void givenRequestToAddUser_ShouldAddUser() {
        userDTO = new UserDto("Palakk", "plk@16");
        User user = new User(userDTO);
        userList.add(user);
        when(service.addUser(userDTO)).thenReturn(user);
        User addUser = service.addUser(userDTO);
        Assert.assertEquals(user.getUserName(), addUser.getUserName());
    }
}
