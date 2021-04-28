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

/**
* @Author: 尚学堂 雷哥
*/

/**
    * 支付订单详情表
    */
@ApiModel(value="com-lzy-domain-OrderChargeItem")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_order_charge_item")
public class OrderChargeItem extends BaseEntity {
    /**
     * 详情ID和his_care_order_*表里面的ID一样
     */
    @TableId(value = "item_id", type = IdType.INPUT)
    @ApiModelProperty(value="详情ID和his_care_order_*表里面的ID一样")
    private String itemId;

    /**
     * 处方ID【备用】
     */
    @TableField(value = "co_id")
    @ApiModelProperty(value="处方ID【备用】")
    private String coId;

    /**
     * 项目名称
     */
    @TableField(value = "item_name")
    @ApiModelProperty(value="项目名称")
    private String itemName;

    /**
     * 项目价格
     */
    @TableField(value = "item_price")
    @ApiModelProperty(value="项目价格")
    private BigDecimal itemPrice;

    /**
     * 项目数量
     */
    @TableField(value = "item_num")
    @ApiModelProperty(value="项目数量")
    private Integer itemNum;

    /**
     * 小计
     */
    @TableField(value = "item_amount")
    @ApiModelProperty(value="小计")
    private Long itemAmount;

    /**
     * 订单IDhis_oder_charge主键
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单IDhis_oder_charge主键")
    private String orderId;

    /**
     * 项目类型0药品  还是1检查项
     */
    @TableField(value = "item_type")
    @ApiModelProperty(value="项目类型0药品  还是1检查项")
    private String itemType;

    /**
     * 状态，0未支付，1已支付，2，已退费  3，已完成 字典表 his_order_details_status
     */
    @TableField(value = "status")
    @ApiModelProperty(value="状态，0未支付，1已支付，2，已退费  3，已完成 字典表 his_order_details_status")
    private String status;

    public static final String COL_ITEM_ID = "item_id";

    public static final String COL_CO_ID = "co_id";

    public static final String COL_ITEM_NAME = "item_name";

    public static final String COL_ITEM_PRICE = "item_price";

    public static final String COL_ITEM_NUM = "item_num";

    public static final String COL_ITEM_AMOUNT = "item_amount";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ITEM_TYPE = "item_type";

    public static final String COL_STATUS = "status";
}