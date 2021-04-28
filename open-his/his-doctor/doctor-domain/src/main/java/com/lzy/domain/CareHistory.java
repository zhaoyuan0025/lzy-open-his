package com.lzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @Author: 尚学堂 雷哥
*/

/**
    * 病例表
    */
@ApiModel(value="com-lzy-domain-CareHistory")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_care_history")
public class CareHistory extends BaseEntity {
    /**
     * 病历ID
     */
    @TableId(value = "ch_id", type = IdType.INPUT)
    @ApiModelProperty(value="病历ID")
    private String chId;

    /**
     * 医生id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="医生id")
    private Long userId;

    /**
     * 医生姓名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value="医生姓名")
    private String userName;

    /**
     * 患者id
     */
    @TableField(value = "patient_id")
    @ApiModelProperty(value="患者id")
    private String patientId;

    /**
     * 患者姓名
     */
    @TableField(value = "patient_name")
    @ApiModelProperty(value="患者姓名")
    private String patientName;

    /**
     * 科室id
     */
    @TableField(value = "dept_id")
    @ApiModelProperty(value="科室id")
    private Long deptId;

    /**
     * 科室名称
     */
    @TableField(value = "dept_name")
    @ApiModelProperty(value="科室名称")
    private String deptName;

    /**
     * 接诊类型：0初诊，1复诊  字典表属性his_receive_type
     */
    @TableField(value = "receive_type")
    @ApiModelProperty(value="接诊类型：0初诊，1复诊  字典表属性his_receive_type")
    private String receiveType;

    /**
     * 是否传染，0否，1是 字典表属性his_contagious_status
     */
    @TableField(value = "is_contagious")
    @ApiModelProperty(value="是否传染，0否，1是 字典表属性his_contagious_status")
    private String isContagious;

    /**
     * 就诊时间
     */
    @TableField(value = "care_date")
    @ApiModelProperty(value="就诊时间")
    private Date careDate;

    /**
     * 发病日期
     */
    @TableField(value = "case_date")
    @ApiModelProperty(value="发病日期")
    private String caseDate;

    /**
     * 挂号单号
     */
    @TableField(value = "reg_id")
    @ApiModelProperty(value="挂号单号")
    private String regId;

    /**
     * 主诉
     */
    @TableField(value = "case_title")
    @ApiModelProperty(value="主诉")
    private String caseTitle;

    /**
     * 诊断信息
     */
    @TableField(value = "case_result")
    @ApiModelProperty(value="诊断信息")
    private String caseResult;

    /**
     * 医生建议
     */
    @TableField(value = "doctor_tips")
    @ApiModelProperty(value="医生建议")
    private String doctorTips;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    public static final String COL_CH_ID = "ch_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_PATIENT_NAME = "patient_name";

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_DEPT_NAME = "dept_name";

    public static final String COL_RECEIVE_TYPE = "receive_type";

    public static final String COL_IS_CONTAGIOUS = "is_contagious";

    public static final String COL_CARE_DATE = "care_date";

    public static final String COL_CASE_DATE = "case_date";

    public static final String COL_REG_ID = "reg_id";

    public static final String COL_CASE_TITLE = "case_title";

    public static final String COL_CASE_RESULT = "case_result";

    public static final String COL_DOCTOR_TIPS = "doctor_tips";

    public static final String COL_REMARK = "remark";
}