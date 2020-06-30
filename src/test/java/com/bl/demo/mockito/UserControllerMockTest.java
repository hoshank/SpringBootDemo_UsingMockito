package com.bl.demo.mockito;
/**
 * purpose:Mocking database layer
 * Author:Plk
 */

import com.bl.demo.DemoApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
public class UserControllerMockTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    /**
     * Initializes the mockMvc
     */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * purpose:checks the number of rows in database
     * @throws Exception
     */
    @Test
    public void verifyAllUserList() throws Exception {
        mockMvc.perform(get("/user/display").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(9))).andDo(print());
    }

    /**
     * purpose:check the fields if present in database
     * @throws Exception
     */
    @Test
    public void verifyUserById() throws Exception {
        mockMvc.perform(get("/user/display")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("[4].id").exists())
                .andExpect(jsonPath("[4].userName").exists())
                .andDo(print());
    }
    @Test
    public void GivenWrongUrl_ShouldReturnErrorCode() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello").
                accept(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(404,mvcResult.getResponse().getStatus());

    }
    @Test
    public void GivenWrongUrl_ShouldReturnError() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello").
                accept(MediaType.ALL);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(status().isNotFound(),mvcResult.getResponse().getStatus());

    }
}
