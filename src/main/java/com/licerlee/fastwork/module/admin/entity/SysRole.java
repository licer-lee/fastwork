package com.licerlee.fastwork.module.admin.entity;

import com.licerlee.fastwork.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author licer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sys_role")
public class SysRole extends BaseEntity {

    @Column(nullable = false)
    private String roleName;

}
