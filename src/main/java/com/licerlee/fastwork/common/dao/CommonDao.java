package com.licerlee.fastwork.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 基础Dao接口定义
 * @author licer
 */
@NoRepositoryBean
public interface CommonDao<E,ID extends Serializable> extends JpaRepository<E,ID>, JpaSpecificationExecutor<E> {
}
