package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: 尚学堂 雷哥
 */
@ApiModel(value="com-lzy-dto-CareOrderFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareOrderFormDto implements Serializable {
    //处方
    private CareOrderDto careOrder;
    //处方详情
    @NotEmpty(message = "处方详情不能为空")
    private List<CareOrderItemDto> careOrderItems;
}
