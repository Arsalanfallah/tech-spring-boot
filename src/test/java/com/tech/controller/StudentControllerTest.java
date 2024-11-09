package com.tech.controller;

import com.tech.dto.StudentResponse;
import com.tech.entity.StudentType;
import com.tech.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Use this import


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testSaveStudent() throws Exception {
        String studentJson = "{ \"name\": \"John\", \"age\": 45, \"nationalCode\": \"1234567890\", \"birthDate\": \"1978-04-06\", \"studentType\": \"NORMAL\" }";

        // Mocking the service layer response
        StudentResponse studentResponse = new StudentResponse(456L,"John", 45, "1234567890",StudentType.NORMAL, "1978-04-06",null,null );
        Mockito.when(studentService.saveStudent(Mockito.any())).thenReturn(studentResponse);

        mockMvc.perform(post("/services/students/v1/saveStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andDo(print())  // This will print the response details to the console
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.age").value(45))
                .andExpect(jsonPath("$.nationalCode").value("1234567890"))
                .andExpect(jsonPath("$.birthDate").value("1978-04-06"))
                .andExpect(jsonPath("$.studentType").value("NORMAL"));

    }
}