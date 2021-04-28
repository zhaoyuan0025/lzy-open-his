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

/**
* @Author: 尚学堂 雷哥
*/
@ApiModel(value="com-lzy-dto-CareOrderDto")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class CareOrderDto extends BaseDto {
    /**
     * 处方ID
     */
    @ApiModelProperty(value="处方ID")
    private String coId;

    /**
     * 处方类型0药用处方1检查处方
     */
    @NotBlank(message = "处方类型不能为空")
    @ApiModelProperty(value="处方类型0药用处方1检查处方")
    private String coType;

    /**
     * 医生id
     */
    @ApiModelProperty(value="医生id")
    private Long userId;

    /**
     * 患者id
     */
    @ApiModelProperty(value="患者id")
    private String patientId;

    /**
     * 患者姓名
     */
    @ApiModelProperty(value="患者姓名")
    private String patientName;

    /**
     * 关联病历id
     */
    @NotBlank(message = "病历ID不能为空")
    @ApiModelProperty(value="关联病历id")
    private String chId;

    /**
     * 处方全额
     */
    @NotNull(message = "处方全额不能为空")
    @ApiModelProperty(value="处方全额")
    private BigDecimal allAmount;
}