package com.cts.management.service;

import com.cts.management.dao.RoleDao;
import com.cts.management.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {
    @Mock
    private RoleDao roleDao;
    @InjectMocks
    private RoleService roleService;
    @Test
    public void testCreateNewRole() {
        Role role = new Role();
        role.setRoleName("testRole");
        when(roleDao.save(role)).thenReturn(role);
        Role createdRole = roleService.createNewRole(role);
        assertEquals(role.getRoleName(), createdRole.getRoleName());
    } }