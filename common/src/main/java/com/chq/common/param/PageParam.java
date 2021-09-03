package com.chq.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true)
@Validated
@ApiModel("分页参数对象")
public class PageParam extends ApiParam {

    @ApiModelProperty(value = "页码,默认为1,最小为1", example = "1")
    @Min(1)
    private Integer pageNo;

    @ApiModelProperty(value = "页大小,默认为10，最小为10", example = "10")
    private Integer limit;

    @ApiModelProperty("搜索字符串")
    private String keyword;

    @Override
    public void check() {
        super.check();
    }

    public Integer getPageNo() {
        pageNo = Optional.ofNullable(pageNo).orElse(1);
        return pageNo;
    }

    public Integer getLimit() {
        limit = Optional.ofNullable(limit).orElse(10);
        return limit;
    }
}
