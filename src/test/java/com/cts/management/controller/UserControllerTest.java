package com.cts.management.controller;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.dao.LoanDao;
import com.cts.management.dao.UserDao;
import com.cts.management.entity.Role;
import com.cts.management.entity.User;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.UserService;
import com.cts.management.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;
    @MockBean
    private LoanService loanService;
    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
   private JwtService jwtService;
    @MockBean
    private UserDao userDao;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;



    @Autowired
    private MockMvc mockMvc;

    @Test
    void testinitRoleAndUser(){

        willDoNothing().given(userService).initRoleAndUser();

    }

    @Test
    void testfindUser() throws Exception {
        Set<Role> role=new HashSet<Role>();

        User user=new User("mahesh123","Mahesh","Barde","mahesh@123",role);
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonobj= objectMapper.writeValueAsString(user);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/finduser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonobj)
                )
                .andExpect(status().isOk());
    }

    @Test
    void testregisterNewUSer() throws Exception {
        Set<Role> role=new HashSet<Role>();

        User user=new User("mahesh123","Mahesh","Barde","mahesh@123",role);
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonobj= objectMapper.writeValueAsString(user);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/registerNewUser").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonobj)
                )
                .andExpect(status().isOk());
    }
}
