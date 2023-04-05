package com.cts.management.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.configuration.JwtRequestFilter;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(JwtResponse.class)
class JwtResponseTest {
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
    void testConstructor(){
        Set<Role> role=new HashSet<Role>();
        role.add(new Role("User","Default user"));
        User user=new User("mahesh123","Mahesh","Barde","mahesh@123",role);
        JwtResponse actualResponse=new JwtResponse(user,"token");
        actualResponse.setJwtToken("token");
        assertEquals("token",actualResponse.getJwtToken());
        assertEquals(user,actualResponse.getUser());

        User user1=new User("mahesh123","Mahesh","Barde","mahesh@123",role);
        actualResponse.setUser(user1);
        User user2=actualResponse.getUser();
        assertSame(user1,user2);

    }
}

