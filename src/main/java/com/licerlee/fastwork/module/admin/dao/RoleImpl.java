package com.licerlee.fastwork.module.admin.dao;

import com.licerlee.fastwork.common.dao.BaseCustomDaoImpl;
import com.licerlee.fastwork.module.admin.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * @author licer
 */
public class RoleImpl extends BaseCustomDaoImpl implements RoleCustomDao {


    @Override
    public List<SysRole> findRoles(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("select r from SysRole r ");

        if(params != null){
            StringBuilder sbWhere = new StringBuilder();
            Object name = params.get("roleName");
            if(name != null){
                sbWhere.append(" and r.roleName like :roleName ");
            }

            Object deleteFlag = params.get("deleteFlag");
            if(deleteFlag != null){
                sbWhere.append(" and r.deleteFlag = :deleteFlag ");
            }

            sb.append(sbWhere.toString().replaceFirst("and", "where"));
        }

        sb.append("order by createAt");

        return this.queryByMapParams(sb.toString(), params);
    }
}
