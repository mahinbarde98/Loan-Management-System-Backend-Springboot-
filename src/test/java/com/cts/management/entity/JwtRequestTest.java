package com.cts.management.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.configuration.JwtRequestFilter;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(JwtRequest.class)
class JwtRequestTest {
    @MockBean
    private Loan loan;
    @MockBean
    private LoanService loanService;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private RoleService roleService;
    @MockBean
    private JwtRequestFilter jwtRequestFilter;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Test
    void testContructor(){
        JwtRequest actualRequest=new JwtRequest("mahesh","mahesh@123");
        assertEquals("mahesh",actualRequest.getUserName());
        assertEquals("mahesh@123",actualRequest.getUserPassword());
    }
}

