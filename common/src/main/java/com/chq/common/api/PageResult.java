package com.chq.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页结果数据")
public class PageResult<T> {

    @ApiModelProperty("数据列表")
    private List<T> records;

    @ApiModelProperty("总数")
    private long total;
}
