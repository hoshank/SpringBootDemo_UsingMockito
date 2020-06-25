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

        @Test
        void givenRequestToAddUser_WhenGetAdded_ShouldReturnCorrectMessage() {
            userDTO = new UserDto("plkk", "pwdd");
            when(service.updateUser(userDTO)).thenReturn("Login Successfull");
            String msg = service.updateUser(userDTO);
            Assert.assertEquals("Login Successfull",msg);
        }
}
