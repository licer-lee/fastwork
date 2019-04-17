package com.licerlee.fastwork.common.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author licer
 */
@Data
@MappedSuperclass
public class MysqlLongIdEntity extends IdEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

}
