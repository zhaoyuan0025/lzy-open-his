package com.lzy.dto;

import com.lzy.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
* @Author: 尚学堂 雷哥
 * 支付订单详情表
*/
@ApiModel(value="com-lzy-dto-OrderChargeItemDto")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderChargeItemDto extends BaseEntity {
    /**
     * 详情ID和his_care_order_*表里面的ID一样
     */
    @NotBlank(message = "详情ID不能为空")
    @ApiModelProperty(value="详情ID和his_care_order_*表里面的ID一样")
    private String itemId;

    /**
     * 处方ID【备用】
     */
    @NotBlank(message = "处方ID不能为空")
    @ApiModelProperty(value="处方ID【备用】")
    private String coId;

    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    @ApiModelProperty(value="项目名称")
    private String itemName;

    /**
     * 项目价格
     */
    @NotBlank(message = "项目价格不能为空")
    @ApiModelProperty(value="项目价格")
    private BigDecimal itemPrice;

    /**
     * 项目数量
     */
    @NotNull(message = "项目数量不能为空")
    @ApiModelProperty(value="项目数量")
    private Integer itemNum;

    /**
     * 小计
     */
    @NotNull(message = "项目总价不能为空")
    @ApiModelProperty(value="小计")
    private Long itemAmount;

    /**
     * 订单IDhis_oder_charge主键
     */
    @ApiModelProperty(value="订单IDhis_oder_charge主键")
    private String orderId;
    /**
     * 项目类型0药品  还是1检查项
     */
    @NotBlank(message = "项目类型不能为空")
    @ApiModelProperty(value="项目类型0药品  还是1检查项")
    private String itemType;
}