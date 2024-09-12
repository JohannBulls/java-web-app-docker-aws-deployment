package co.edu.escuelaing.java_web_app_docker_aws_deployment.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetingWithDefaultValue() throws Exception {
        this.mockMvc.perform(get("/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testGreetingWithNameParameter() throws Exception {
        this.mockMvc.perform(get("/greeting").param("name", "Johann"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, Johann!"));
    }
}
