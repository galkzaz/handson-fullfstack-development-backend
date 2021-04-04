package me.study.books.handsonfullfstackdevelopment.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

@AutoConfigureMockMvc
@SpringBootTest
public class CarRestTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSucsessAuthentication() throws Exception {
        // Testing authentication with correct credentials
        this.mvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"admin\"}")).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testailedAuthentication() throws Exception {
        // Testing authentication with wrong credentials
        this.mvc.perform(post("/login").content("{\"username\":\"admin\", \"password\":\"wrongpwd\"}")).andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
