package com.cts.management.JwtUtil;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.entity.JwtResponse;
import com.cts.management.service.JwtService;
import com.cts.management.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(JwtUtil.class)
public class JwtUtilTest {

    @MockBean
    private UserDetails userDetails;
    @MockBean
    JwtUtil jwtUtil;
    @MockBean
    JwtService jwtService;
    @MockBean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Test
    void testgetUsernameFromToken(){
        JwtResponse jwtResponse=new JwtResponse();
       String token=jwtResponse.getJwtToken();
       assertThat(jwtUtil.getUsernameFromToken(token)).isNotNull();
    }

}
