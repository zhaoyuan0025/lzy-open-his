package com.lzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lzy.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 尚学堂 雷哥
 *  部门/科室表
*/
@ApiModel(value="com-lzy-domain-Dept")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_dept")
public class Dept extends BaseEntity {
    /**
     * 部门科室id
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    @ApiModelProperty(value="部门科室id")
    private Long deptId;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    @ApiModelProperty(value="部门名称")
    private String deptName;

    /**
     * 挂号编号
     */
    @TableField(value = "reg_number")
    @ApiModelProperty(value="挂号编号")
    private Integer regNumber;

    /**
     * 科室编号
     */
    @TableField(value = "dept_number")
    @ApiModelProperty(value="科室编号")
    private String deptNumber;

    /**
     * 显示顺序
     */
    @TableField(value = "order_num")
    @ApiModelProperty(value="显示顺序")
    private Integer orderNum;

    /**
     * 负责人
     */
    @TableField(value = "dept_leader")
    @ApiModelProperty(value="负责人")
    private String deptLeader;

    /**
     * 联系电话
     */
    @TableField(value = "leader_phone")
    @ApiModelProperty(value="联系电话")
    private String leaderPhone;

    /**
     * 部门状态（0正常 1停用）
     */
    @TableField(value = "status")
    @ApiModelProperty(value="部门状态（0正常 1停用）")
    private String status;


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
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
     * 物理删除
     */
//    @TableField(value = "deleted")
//    @ApiModelProperty(value="物理删除")
//    private Integer deleted;

    public static final String COL_DEPT_ID = "dept_id";

    public static final String COL_DEPT_NAME = "dept_name";

    public static final String COL_REG_NUMBER = "reg_number";

    public static final String COL_DEPT_NUMBER = "dept_number";

    public static final String COL_ORDER_NUM = "order_num";

    public static final String COL_DEPT_LEADER = "dept_leader";

    public static final String COL_LEADER_PHONE = "leader_phone";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_UPDATE_BY = "update_by";
}