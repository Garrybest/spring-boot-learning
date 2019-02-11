package com.garrybest;

import com.garrybest.web.UserController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request;

        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));

        request = MockMvcRequestBuilders.post("/users")
                .param("id", "1")
                .param("name", "fr")
                .param("age", "25");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")))
                .andDo(MockMvcResultHandlers.print());

        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"fr\",\"age\":25}]")));

        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "fr")
                .param("age", "24");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"fr\",\"age\":24}]")));

        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
    }
}

