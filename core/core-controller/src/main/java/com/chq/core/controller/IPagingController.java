package com.chq.core.controller;


import com.chq.common.pojo.PageInfo;
import com.chq.common.pojo.PageRequestDto;
import com.chq.common.pojo.Result;


public interface IPagingController<T> {

    /**
     * 根据查询条件 requestDto 分页查询
     * @return
     */
    Result<PageInfo<T>> findByPage(PageRequestDto<T> requestDto);


}
