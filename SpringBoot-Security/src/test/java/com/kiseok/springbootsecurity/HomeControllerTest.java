package com.kiseok.springbootsecurity;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest extends TestCase {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_hello_without_user() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isUnauthorized())
        ;
    }

    @Test
    @WithMockUser
    public void test_hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
        ;
    }

    @Test
    public void test_hello2() throws Exception {
        mockMvc.perform(get("/hello")
                .with(user("kiseok").password("pass")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
        ;
    }

    @Test
    @WithMockUser
    public void test_my() throws Exception {
        mockMvc.perform(get("/my"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("my"))
        ;
    }
}