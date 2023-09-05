package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetOkStatus() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    @Test
    void shouldGetOkStatusAndBody() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cidade").value("Curitiba"))
                .andExpect(jsonPath("$.estado").value("Paraná"));
    }
}
