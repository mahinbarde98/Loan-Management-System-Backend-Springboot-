package com.cts.management.controller;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.entity.JwtRequest;

import com.cts.management.service.JwtService;
import com.cts.management.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(JwtController.class)
//@AutoConfigureMockMvc(addFilters = false)

public class JwtControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
    JwtService jwtService;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Test
    void createJwtToken() throws Exception {

        JwtRequest jwtRequest =new JwtRequest("admin123","admin@pass");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonobj = objectMapper.writeValueAsString(jwtRequest);
        this.mockMvc.perform(post("/authenticate").
                contentType(MediaType.APPLICATION_JSON).content(jsonobj)).
                andExpect(status().isOk());


    }


}
