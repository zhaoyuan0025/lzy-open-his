package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @Author: 尚学堂 雷哥
 * 患者信息表
*/
@ApiModel(value="com-lzy-dto-PatientDto")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto extends BaseDto {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private String patientId;

    /**
     * 患者姓名
     */
    @ApiModelProperty(value="患者姓名")
    @NotBlank(message = "患者姓名不能为空")
    private String name;

    /**
     * 患者电话
     */
    @NotBlank(message = "患者电话不能为空")
    @ApiModelProperty(value="患者电话")
    private String phone;

    /**
     * 患者性别0男1女 2未知字典表 sys_user_sex
     */
    @NotBlank(message = "患者性别不能为空")
    @ApiModelProperty(value="患者性别0男1女 2未知字典表 sys_user_sex")
    private String sex;

    /**
     * 出生年月
     */
    @NotBlank(message = "患者出生年月不能为空")
    @ApiModelProperty(value="出生年月")
    private String birthday;

    /**
     * 身份证号[认证ID]
     */
    @NotBlank(message = "身份证号不能为空")
    @ApiModelProperty(value="身份证号[认证ID]")
    private String idCard;

    /**
     * 地址信息
     */
    @ApiModelProperty(value="地址信息")
    private String address;

    /**
     * 过敏信息
     */
    @ApiModelProperty(value="过敏信息")
    private String allergyInfo;

}