package com.spring.rest.test;


import com.spring.rest.WelcomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WelcomeController.class)
public class JMap {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/wish")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Helllllllllloooooooooooo")));
    }
}
