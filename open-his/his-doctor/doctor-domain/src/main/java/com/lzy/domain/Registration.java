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

@ApiModel(value="com-lzy-domain-Registration")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_registration")
public class Registration extends BaseEntity {
    /**
     * 挂号流水
     */
    @TableId(value = "reg_id", type = IdType.INPUT)
    @ApiModelProperty(value="挂号流水")
    private String regId;

    /**
     * 患者ID
     */
    @TableField(value = "patient_id")
    @ApiModelProperty(value="患者ID")
    private String patientId;

    /**
     * 患者姓名
     */
    @TableField(value = "patient_name")
    @ApiModelProperty(value="患者姓名")
    private String patientName;

    /**
     * 接诊医生ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="接诊医生ID")
    private Long userId;

    /**
     * 接诊医生姓名
     */
    @TableField(value = "doctor_name")
    @ApiModelProperty(value="接诊医生姓名")
    private String doctorName;

    /**
     * 科室ID
     */
    @TableField(value = "dept_id")
    @ApiModelProperty(value="科室ID")
    private Long deptId;

    /**
     * 挂号费用ID
     */
    @TableField(value = "reg_item_id")
    @ApiModelProperty(value="挂号费用ID")
    private Long regItemId;

    /**
     * 挂号总金额
     */
    @TableField(value = "reg_item_amount")
    @ApiModelProperty(value="挂号总金额")
    private BigDecimal regItemAmount;

    /**
     * 挂号编号
     */
    @TableField(value = "reg_number")
    @ApiModelProperty(value="挂号编号")
    private Integer regNumber;

    /**
     * 挂号状态0未收费,1待就诊，2,就诊中，3，就诊完成，4，已退号，5 作废
     */
    @TableField(value = "reg_status")
    @ApiModelProperty(value="挂号状态0未收费,1待就诊，2,就诊中，3，就诊完成，4，已退号，5 作废")
    private String regStatus;

    /**
     * 就诊日期
     */
    @TableField(value = "visit_date")
    @ApiModelProperty(value="就诊日期")
    private String visitDate;

    /**
     * 排班类型1 门诊 2 急诊 字典表数据翻译
     */
    @TableField(value = "scheduling_type")
    @ApiModelProperty(value="排班类型1 门诊 2 急诊 字典表数据翻译")
    private String schedulingType;

    /**
     * 排班时段1上午  2下午 3晚上 字典表数据翻译
     */
    @TableField(value = "subsection_type")
    @ApiModelProperty(value="排班时段1上午  2下午 3晚上 字典表数据翻译")
    private String subsectionType;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建人")
    private String createBy;

    public static final String COL_REG_ID = "reg_id";

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_PATIENT_NAME = "patient_name";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_DOCTOR_NAME = "doctor_name";

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_REG_ITEM_ID = "reg_item_id";

    public static final String COL_REG_ITEM_AMOUNT = "reg_item_amount";

    public static final String COL_REG_NUMBER = "reg_number";

    public static final String COL_REG_STATUS = "reg_status";

    public static final String COL_VISIT_DATE = "visit_date";

    public static final String COL_SCHEDULING_TYPE = "scheduling_type";

    public static final String COL_SUBSECTION_TYPE = "subsection_type";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";
}