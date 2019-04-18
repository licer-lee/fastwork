package com.licerlee.fastwork.module.admin.service;

import com.licerlee.fastwork.common.service.AbstractService;
import com.licerlee.fastwork.module.admin.dao.RoleDao;
import com.licerlee.fastwork.module.admin.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author licer
 */
@Service
public class RoleService extends AbstractService<SysRole, String> {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        super.setCommonDao(roleDao);
    }

    public List<SysRole> findRoles(Map<String, Object> params) {
        return roleDao.findRoles(params);
    }

    public void updateDeleteFlag(String[] ids, Integer deleteFlag){
        if(ids != null){
            for(String id : ids){
                Optional<SysRole> role = this.find(id);
                role.ifPresent(r ->{
                    r.setDeletedFlag(deleteFlag);
                    this.update(r);
                });
            }
        }
    }

    public SysRole findByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }

//    /**
//     * 根据查询条件查询角色分页信息
//     * @param userQueryDTO
//     * @return
//     */
//    public PageModel<Role> queryRolePage(RoleQueryDTO roleQueryDTO){
//        return this.roleDao.queryRolePage(roleQueryDTO);
//    }
}
