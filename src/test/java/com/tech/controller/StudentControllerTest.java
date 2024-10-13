package com.tech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Use this import


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testSaveStudent() throws Exception {
        String studentJson = "{ \"name\": \"John\", \"age\": 45, \"nationalCode\": \"1234567890\",\"birthDate\": \"1978-04-06\", \"studentType\": \"NORMAL\" }";

        mockMvc.perform(post("/services/students/v1/saveStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.age").value(45))
                .andExpect(jsonPath("$.nationalCode").value("1234567890"))
                .andExpect(jsonPath("$.birthDate").value("1978-04-06"))
                .andExpect(jsonPath("$.studentType").value("NORMAL"));
    }
}
