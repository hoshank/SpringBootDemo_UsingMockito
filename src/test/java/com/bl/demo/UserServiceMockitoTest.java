package com.bl.demo;

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;
import com.bl.demo.repository.UserRepository;
import com.bl.demo.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceMockitoTest {
    @Mock
    UserRepository repository;
    @Autowired
    IUserService userService;

    UserDto userDTO;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenRequest_WhenGetResponse_ShouldReturnUserDetailsList() {
        userDTO = new UserDto("plk", "pwd");
        when(repository.save(any())).thenReturn(new User());
        String msg = userService.updateUser(userDTO);
        Assert.assertEquals("Login successfull", msg);
    }
}
