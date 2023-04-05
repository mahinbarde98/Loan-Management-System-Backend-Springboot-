package com.cts.management.entity;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.configuration.JwtRequestFilter;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
@WebMvcTest(Role.class)
public class RoleTest {

    @MockBean
    private RoleService roleService;
    @MockBean
    private JwtRequestFilter jwtRequestFilter;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @MockBean
    private UserDetailsService userDetailsService;


   ;

    @Test
    void testroleName(){
        Role role=new Role("Admin","Only Admin");
        role.setRoleName("Admin");
        assertEquals(role.getRoleName(),"Admin");
    }
    @Test
    void testroleDescription(){
        Role role=new Role();
        role.setRoleName("Admin");
        role.setRoleDescription("Only Admin");
        assertEquals(role.getRoleDescription(),"Only Admin");
    }
}
