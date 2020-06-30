package com.bl.demo.mockito;
/**
 * purpose:mock the service layer that the controller is dependant on
 */

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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
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

    /**
     * TC to check if login is successfull or not
     */
    @Test
    public void givenCorrectLoginRequest_WhenGetResponse_ShouldReturnUserDetailsList() {
        userDTO = new UserDto("tanu", "kanu");
        User user = new User(userDTO);
        when(service.loginUser(any())).thenReturn(Optional.of(user));
        Optional<User> userOptional = service.loginUser(userDTO);
        Assert.assertEquals(user.getUserName(),userOptional.get().getUserName());

    }
    /**
     * TC to check if registration is done
     */

    @Test
    public void givenRequestToAddUser_ShouldAddUser() {
        userDTO = new UserDto("Palakk", "plk@16");
        User user = new User(userDTO);
        userList.add(user);
        when(service.registerUser(userDTO)).thenReturn(user);
        User addUser = service.registerUser(userDTO);
        Assert.assertEquals(user.getUserName(), addUser.getUserName());
    }
}