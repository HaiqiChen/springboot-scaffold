package com.chq.core.controller;


import com.chq.common.pojo.Result;

import java.io.Serializable;
import java.util.List;


public interface ISelectController<T> {
    //根据ID 获取信息
    public Result<T> findById(Serializable id);

    //根据ID 获取信息列表
    public Result<List<T>> findAll();

    /**
     * 根据等号条件进行查询 一定等号条件
     * @param record
     * @return
     */
    public Result<List<T>> findByRecord(T record);

}
