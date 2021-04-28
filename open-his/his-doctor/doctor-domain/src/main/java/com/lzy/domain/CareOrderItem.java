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
    * 开诊细表
    */
@ApiModel(value="com-lzy-domain-CareOrderItem")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_care_order_item")
public class CareOrderItem extends BaseEntity {
    /**
     * 开诊明细ID
     */
    @TableId(value = "item_id", type = IdType.INPUT)
    @ApiModelProperty(value="开诊明细ID")
    private String itemId;

    /**
     * 所属处方id
     */
    @TableField(value = "co_id")
    @ApiModelProperty(value="所属处方id")
    private String coId;

    /**
     * 药品或者检查项目id
     */
    @TableField(value = "item_ref_id")
    @ApiModelProperty(value="药品或者检查项目id")
    private String itemRefId;

    /**
     * 药品或检查项目名称
     */
    @TableField(value = "item_name")
    @ApiModelProperty(value="药品或检查项目名称")
    private String itemName;

    /**
     * 项目类型0药品  还是1检查项
     */
    @TableField(value = "item_type")
    @ApiModelProperty(value="项目类型0药品  还是1检查项")
    private String itemType;

    /**
     * 数量
     */
    @TableField(value = "num")
    @ApiModelProperty(value="数量")
    private BigDecimal num;

    /**
     * 单价
     */
    @TableField(value = "price")
    @ApiModelProperty(value="单价")
    private BigDecimal price;

    /**
     * 金额
     */
    @TableField(value = "amount")
    @ApiModelProperty(value="金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 状态，0未支付，1已支付，2，已退费  3，已完成 字典表his_order_details_status
     */
    @TableField(value = "status")
    @ApiModelProperty(value="状态，0未支付，1已支付，2，已退费  3，已完成 字典表his_order_details_status")
    private String status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    public static final String COL_ITEM_ID = "item_id";

    public static final String COL_CO_ID = "co_id";

    public static final String COL_ITEM_REF_ID = "item_ref_id";

    public static final String COL_ITEM_NAME = "item_name";

    public static final String COL_ITEM_TYPE = "item_type";

    public static final String COL_NUM = "num";

    public static final String COL_PRICE = "price";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_REMARK = "remark";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_TIME = "create_time";
}