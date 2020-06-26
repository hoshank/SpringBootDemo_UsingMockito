package com.bl.demo;

import com.bl.demo.repository.UserRepository;
import com.bl.demo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)

@SpringBootTest
class DemoApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    IUserService loginService;

    @MockBean
    UserRepository loginRepository;

    @Test
    void contextLoads() {
    }


}
