package com.licerlee.fastwork.dao;

import com.licerlee.fastwork.module.admin.dao.RoleDao;
import com.licerlee.fastwork.module.admin.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class RoleDaoTest {

    @Autowired
    RoleDao roleDao;

    @Test
    @Rollback(value = false)
    public void addRoleTest(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("admin"+ new Random().nextInt());
        sysRole.setCreateBy("system");
        sysRole.setUpdateBy("system");
        roleDao.save(sysRole);

        log.info(sysRole.getId());
        Assert.notNull(sysRole.getId(), "id must not be null");

    }

    @Test
    public void getRole(){
        Optional<SysRole> tRole = roleDao.findById("2c9c4aa16a30ee08016a30ee0f240000");
        log.info(ToStringBuilder.reflectionToString(tRole.get(), ToStringStyle.JSON_STYLE));
        org.junit.Assert.assertEquals(true, tRole.isPresent());

    }

    @Test
    public void getAll(){
        List<SysRole> roles = roleDao.findAll();
        org.junit.Assert.assertEquals(2, roles.size());
    }

    @Test
    public void updateRole(){
        Optional<SysRole> tRole = roleDao.findById("2c9c4aa16a30ee08016a30ee0f240000");
        tRole.ifPresent(sysRole1 -> {
            sysRole1.setRoleName("updated12");
            roleDao.save(sysRole1);

            org.junit.Assert.assertEquals(sysRole1.getCreateAt(), sysRole1.getUpdateAt());

        });

    }

    @Test
    public void deleteRole(){

        roleDao.deleteById("2c9c4aa16a30eb19016a30eb1f900000");

        Optional<SysRole> role = roleDao.findById("2c9c4aa16a30eb19016a30eb1f900000");

        org.junit.Assert.assertEquals(true, !role.isPresent());

    }

}
