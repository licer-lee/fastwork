package com.licerlee.fastwork;

import com.licerlee.fastwork.module.admin.dao.RoleDao;
import com.licerlee.fastwork.module.admin.entity.TRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class FastworkApplicationTests {

    @Autowired
    RoleDao roleDao;


    @Before
    public void init(){

    }

    @After
    public void after(){

    }

    @Test
    public void contextLoads() {
    }

    @Test
    @Rollback(value = false)
    public void addRoleTest(){
        TRole tRole = new TRole();
        tRole.setRoleName("admin"+ new Random().nextInt());
        tRole.setCreateBy("system");
        tRole.setUpdateBy("system");
        roleDao.save(tRole);

        log.info(tRole.getId());
        Assert.notNull(tRole.getId(), "id must not be null");

    }

    @Test
    public void getRole(){
        Optional<TRole> tRole = roleDao.findById("2c9c4aa16a30ee08016a30ee0f240000");
        log.info(ToStringBuilder.reflectionToString(tRole.get(), ToStringStyle.JSON_STYLE));
        org.junit.Assert.assertEquals(true, tRole.isPresent());

    }

    @Test
    public void getAll(){
        List<TRole> roles = roleDao.findAll();
        org.junit.Assert.assertEquals(2, roles.size());
    }

    @Test
    public void updateRole(){
        Optional<TRole> tRole = roleDao.findById("2c9c4aa16a30ee08016a30ee0f240000");
        tRole.ifPresent(tRole1 -> {
            tRole1.setRoleName("updated12");
            roleDao.save(tRole1);

            org.junit.Assert.assertEquals(tRole1.getCreateAt(), tRole1.getUpdateAt());

        });

    }

    @Test
    public void deleteRole(){

        roleDao.deleteById("2c9c4aa16a30eb19016a30eb1f900000");

        Optional<TRole> role = roleDao.findById("2c9c4aa16a30eb19016a30eb1f900000");

        org.junit.Assert.assertEquals(true, !role.isPresent());

    }

}
