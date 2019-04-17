package com.licerlee.fastwork.common.service;

import com.licerlee.fastwork.common.dao.CommonDao;

import java.io.Serializable;

public abstract class CommonServiceImpl<E,ID extends Serializable> {

    protected CommonDao<E,ID> commonDao;

    public void setCommonDao(CommonDao<E, ID> commonDao) {
        this.commonDao = commonDao;
    }

    public CommonDao<E, ID> getCommonDao() {
        return commonDao;
    }


    public E get(ID id){
        return commonDao.getOne(id);
    }


}
