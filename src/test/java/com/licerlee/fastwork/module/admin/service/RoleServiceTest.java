package com.licerlee.fastwork.module.admin.service;

import com.licerlee.fastwork.BaseTests;
import com.licerlee.fastwork.module.admin.entity.SysRole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;


public class RoleServiceTest extends BaseTests {

    @Autowired
    RoleService roleService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() {
    }

    @Test
    public void find() {
    }

    @Test
    public void getAll() {
        List<SysRole> roles = roleService.getAll();
        Assert.assertEquals(4, roles.size());
    }

    @Test
    public void getTotalCount() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void delete1() {
    }

    @Test
    public void delete2() {
    }

    @Test
    public void flush() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAll1() {
    }

    @Test
    public void findAll2() {
    }

    @Test
    public void findAll3() {
    }

    @Test
    public void count() {
    }

    @Test
    public void setRoleDao() {
    }

    @Test
    public void findRoles() {
    }

    @Test
    public void updateDeleteFlag() {
    }

    @Test
    public void findByRoleName() {
    }
}