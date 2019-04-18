package com.licerlee.fastwork.module.admin.dao;

import com.licerlee.fastwork.common.entity.PageModel;
import com.licerlee.fastwork.module.admin.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface RoleCustomDao {

    public List<SysRole> findRoles(Map<String, Object> params);

//    /**
//     * 根据查询条件查询角色分页信息
//     * @param userQueryDTO
//     * @return
//     */
//    PageModel<SysRole> queryRolePage(RoleQueryDTO roleQueryDTO);
}
