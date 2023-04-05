package com.cts.management.service;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.controller.JwtController;
import com.cts.management.dao.UserDao;
import com.cts.management.entity.JwtRequest;
import com.cts.management.entity.JwtResponse;
import com.cts.management.entity.Role;
import com.cts.management.entity.User;
import com.cts.management.util.JwtUtil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {JwtService.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(JwtService.class)
public class JwtServiceTest {
    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
    private UserDao userDao;
    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    JwtService jwtService;
    @MockBean
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @MockBean
    UserDetails userDetails;
    @MockBean
    JwtController jwtController;
    @MockBean
    JwtResponse jwtResponse;

    /**
     * Method under test: {@link JwtService#createJwtToken(JwtRequest)}
     */
    @Test
    void testCreateJwtToken() throws Exception {
        when(jwtUtil.generateToken((UserDetails) any())).thenReturn("ABC123");

        User user = new User();
        user.setRole(new HashSet<>());
        user.setUserFirstName("mahesh");
        user.setUserLastName("barde");
        user.setUserName("maheshbarde");
        user.setUserPassword("mahesh123");
        Optional<User> ofResult = Optional.of(user);
        when(userDao.findById((String) any())).thenReturn(ofResult);
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));
        JwtResponse actualCreateJwtTokenResult = jwtService.createJwtToken(new JwtRequest("maheshbarde", "mahesh123"));
        assertEquals("ABC123", actualCreateJwtTokenResult.getJwtToken());
        assertSame(user, actualCreateJwtTokenResult.getUser());
        verify(jwtUtil).generateToken((UserDetails) any());
        verify(userDao, atLeast(1)).findById((String) any());
        verify(authenticationManager).authenticate((Authentication) any());
    }

        @Test
    void testcreateJwtToken() throws Exception {

        //given setup or pre cond
        JwtRequest jwtRequest =new JwtRequest("admin123","admin@pass");

        //when-action or the testong
        when(authenticationManager.authenticate((Authentication) any())).thenReturn(new TestingAuthenticationToken("Principal","Credentials"));
        JwtResponse jwtResponse=jwtService.createJwtToken(jwtRequest);

        //then- verify output
        assertThat(jwtResponse).isNotNull();
    }

    @Test
    void testcreateJwtToken11() throws Exception {
        User user1=new User();
        user1.setRole(new HashSet<>());
        user1.setUserFirstName("abc");
        user1.setUserLastName("abc");
        user1.setUserName("admin123");
        user1.setUserPassword("pass");
        JwtRequest jwtRequest =new JwtRequest("admin123","admin@pass");

        UserDetails userDetails = jwtService.loadUserByUsername(jwtRequest.getUserName());
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userDao.findById(jwtRequest.getUserName()).get();
        //when-action or the testong
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken(jwtRequest.getUserName(),jwtRequest.getUserPassword()));
        JwtResponse jwtResponse=new JwtResponse(user,newGeneratedToken);
//        ResultActions result
        //then- verify output
        assertThat(jwtResponse).isNull();
    }

    @Test
    public void testGenerateToken() throws Exception {
        User user = new User();
        user.setRole(new HashSet<>());
        user.setUserFirstName("mahesh");
        user.setUserLastName("barde");
        user.setUserName("maheshbarde");
        user.setUserPassword("mahesh123");
        when(userDao.findById("username")).thenReturn(Optional.of(user));
        UserDetails userDetails = jwtService.loadUserByUsername("username");
        String token = jwtUtil.generateToken(userDetails);
        assertNotNull(token);
    }
    @Test
    public void testCreateJwtToken20() throws Exception {
        JwtRequest jwtRequest = new JwtRequest("username", "password");
        User user = new User();
        user.setRole(new HashSet<>());
        user.setUserFirstName("mahesh");
        user.setUserLastName("barde");
        user.setUserName("maheshbarde");
        user.setUserPassword("mahesh123");
        when(userDao.findById("username")).thenReturn(Optional.of(user));
        when(jwtUtil.generateToken(any(UserDetails.class))).thenReturn("jwt-token");
        //JwtResponse jwtResponse = jwtController.createJwtToken(jwtRequest);
       // assertNotNull(jwtResponse);
        assertEquals(user, jwtResponse.getUser());
        assertEquals("jwt-token", jwtResponse.getJwtToken()); }
}
