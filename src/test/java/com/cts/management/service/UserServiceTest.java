package com.cts.management.service;

import com.cts.management.dao.RoleDao;
import com.cts.management.dao.UserDao;
import com.cts.management.entity.Role;
import com.cts.management.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserDao userDao;

    @Mock
    RoleDao roleDao;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    public void testInItRecord() {

        when(userService.getEncodedPassword(anyString())).thenReturn(String.valueOf((new BCryptPasswordEncoder())));
        userService.initRoleAndUser();
        verify(userDao, times(2)).save(any());
        verify(roleDao, times(2)).save(any());
    }

    @Test
    public void testgetEncodedPassword() {
        when(passwordEncoder.encode("mahesh")).thenReturn("mahesh");
        String pass = userService.getEncodedPassword("mahesh");
        assertEquals("mahesh", pass);
    }

    @Test
    public void testregisterNewUser() {

        when(roleDao.findById("User")).thenReturn(Optional.of(new Role()));
        User user = new User();
        when(userDao.save(user)).thenReturn(user);
        User user1 = userService.registerNewUser(user);
        assertEquals(user,user1);

    }

}
