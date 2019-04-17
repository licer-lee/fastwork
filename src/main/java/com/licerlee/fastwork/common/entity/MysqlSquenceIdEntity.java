package com.licerlee.fastwork.common.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author licer
 */
@Data
@MappedSuperclass
public class MysqlSquenceIdEntity extends IdEntity{

    @Id
    @Column(length = 32, nullable = false)
    @GenericGenerator(name = "sys_uuid", strategy = "uuid")
    @GeneratedValue(generator = "sys_uuid")
    protected String id;

}
