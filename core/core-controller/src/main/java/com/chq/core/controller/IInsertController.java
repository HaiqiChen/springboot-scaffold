package com.chq.core.controller;


import com.chq.common.pojo.Result;


public interface IInsertController<T> {
    /**
     * 添加记录
     * @param record
     * @return
     */
    Result insert(T record);



}