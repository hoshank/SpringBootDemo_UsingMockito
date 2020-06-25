package com.bl.demo.mockito;

import com.bl.demo.controller.LoginController;
import com.bl.demo.model.User;
import com.bl.demo.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginControllerMockitoTest {
    @Autowired
    MockMvc mockmvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    IUserService userService;
/*
    @Test
    void getAllUsers_ReturnsOK_WithListOfUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        // Response response=new Response
        User user = new User();
        user.setId(2);
        user.setUserName("Plk");
        user.setPassword("Plkk");
        userList.add(user);

        Mockito.when(userService.getAllUser()).thenReturn(userList);

        mockmvc.perform(MockMvcRequestBuilders.get("/login/get").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));

    }*/

/*    @Test
    public void should_GetAccount_When_ValidRequest() throws Exception {

        *//* setup mock *//*
        User user = new User("plk", "pwd");
        when(userService.getAllUser()).thenReturn(user);
        mockmvc.perform((RequestBuilder) get("/login/get")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.userName").value("plk"))
                .andExpect(jsonPath("$.password").value("pwd"))
                .andExpect(jsonPath("$.id").value(5));
    }*/
   /* @Test
    public void should_CreateAccount_When_ValidRequest() throws Exception {

        when(userService.addUser(any(UserDTO.class))).thenReturn(new User());
        mockmvc.perform(post("/login/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ "userName":"plk" ,"password":"plkk" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(header().string("Location", "/api/login/1"))
                .andExpect(jsonPath("$.userName").value("PLK"))
                .andExpect(jsonPath("$.password").value("plkk"));

    }*/
}
