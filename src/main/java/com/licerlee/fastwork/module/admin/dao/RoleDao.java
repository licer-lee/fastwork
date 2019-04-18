package com.licerlee.fastwork.module.admin.dao;

import com.licerlee.fastwork.common.dao.CommonDao;
import com.licerlee.fastwork.module.admin.entity.SysRole;

/**
 * @author licer
 */
public interface RoleDao extends RoleCustomDao,  CommonDao<SysRole, String> {


    public SysRole findByRoleName(String roleName);

}
