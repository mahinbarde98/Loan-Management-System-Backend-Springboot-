package com.cts.management.controller;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.entity.Role;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.RoleService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoleController.class)
@AutoConfigureMockMvc
public class RoleControllerTest {

@Autowired
 private MockMvc mockMvc;
@MockBean
private LoanService loanService;
    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private RoleService roleService;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


@Test
void testcreateNewRole() throws Exception {
    Role role = new Role("Admin", "this is admin");

    ObjectMapper objectMapper= new ObjectMapper();
    String jsonObj = objectMapper.writeValueAsString(role);

    this.mockMvc.perform(MockMvcRequestBuilders.post("/createNewRole").
                    contentType(MediaType.APPLICATION_JSON).content(jsonObj)).
            andExpect(status().isOk());
}

}

