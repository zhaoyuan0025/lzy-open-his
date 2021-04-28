package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
* @Author: 尚学堂 雷哥
 * 收费表
*/
@ApiModel(value="com-lzy-dto-OrderChargeDto")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderChargeDto extends BaseDto {
    /**
     * 收费ID
     */
    @ApiModelProperty(value="收费ID")
    private String orderId;

    /**
     * 总费用
     */
    @NotNull(message = "总费用不能为空")
    @ApiModelProperty(value="总费用")
    private BigDecimal orderAmount;

    /**
     * 病历ID
     */
    @NotBlank(message = "病历ID不能为空")
    @ApiModelProperty(value="病历ID")
    private String chId;

    /**
     * 挂号单
     */
    @NotBlank(message = "挂号单不能为空")
    @ApiModelProperty(value="挂号单")
    private String regId;

    /**
     * 患者名称
     */
    @NotBlank(message = "患者名称不能为空")
    @ApiModelProperty(value="患者名称")
    private String patientName;

    /**
     * 订单状态0未支付  1 支付成功  2支付超时 3支付失败 字典表his_order_charge_status
     */
    @ApiModelProperty(value="订单状态0未支付  1 支付成功  2支付超时 3支付失败 字典表his_order_charge_status")
    private String orderStatus;

    /**
     * 支付ID
     */
    @ApiModelProperty(value="支付ID")
    private String payPlatformId;

    /**
     * 支付时间
     */
    @ApiModelProperty(value="支付时间")
    private Date payTime;

    /**
     * 支付类型0现金1支付宝  字典表	his_pay_type_status
     */
    @ApiModelProperty(value="支付类型0现金1支付宝  字典表	his_pay_type_status")
    private String payType;


}