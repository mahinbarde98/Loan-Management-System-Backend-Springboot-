package com.cts.management.entity;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.configuration.JwtRequestFilter;
import com.cts.management.service.LoanService;
import com.cts.management.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
@WebMvcTest(User.class)
public class UserTest {
    @MockBean
    private JwtRequestFilter jwtRequestFilter;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @MockBean
    private LoanService loanService;
    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
     private UserService userService;

    User user=new User();

    @Test
    void testuserName() {
        user.setUserName("mahesh@123");
        assertEquals(user.getUserName(), "mahesh@123");
    }

    @Test
    void testuserFirstName() {
        user.setUserFirstName("mahesh");
        assertEquals(user.getUserFirstName(), "mahesh");
    }

    @Test
    void testuserLastName() {
        user.setUserLastName("barde");
        assertEquals(user.getUserLastName(), "barde");
    }

    @Test
    void testuserPassword() {
        user.setUserPassword("mahesh@123");
        //String password=userService.getEncodedPassword("mahesh@123");
        assertEquals(user.getUserPassword(), "mahesh@123");
    }

}
