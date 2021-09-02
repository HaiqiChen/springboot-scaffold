package com.chq.core.controller;


import com.chq.common.exception.BusinessException;
import com.chq.common.pojo.Result;

import java.io.Serializable;


public interface IDeleteController<T> {
    /**
     * 根据ID 删除
     *
     * @param id
     * @return
     */
    Result deleteById(Serializable id) throws BusinessException;


}
