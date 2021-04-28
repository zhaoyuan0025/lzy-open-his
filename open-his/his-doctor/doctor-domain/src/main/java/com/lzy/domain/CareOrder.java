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

import java.math.BigDecimal;
import java.util.Date;

/**
* @Author: 尚学堂 雷哥
*/

/**
    * 药用处方表
    */
@ApiModel(value="com-lzy-domain-CareOrder")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_care_order")
public class CareOrder extends BaseEntity {
    /**
     * 处方ID
     */
    @TableId(value = "co_id", type = IdType.INPUT)
    @ApiModelProperty(value="处方ID")
    private String coId;

    /**
     * 处方类型0药用处方1检查处方
     */
    @TableField(value = "co_type")
    @ApiModelProperty(value="处方类型0药用处方1检查处方")
    private String coType;

    /**
     * 医生id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="医生id")
    private Long userId;

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
     * 关联病历id
     */
    @TableField(value = "ch_id")
    @ApiModelProperty(value="关联病历id")
    private String chId;

    /**
     * 处方全额
     */
    @TableField(value = "all_amount")
    @ApiModelProperty(value="处方全额")
    private BigDecimal allAmount;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    public static final String COL_CO_ID = "co_id";

    public static final String COL_CO_TYPE = "co_type";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_PATIENT_NAME = "patient_name";

    public static final String COL_CH_ID = "ch_id";

    public static final String COL_ALL_AMOUNT = "all_amount";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";
}