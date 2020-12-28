package com.lzy.enums;

import lombok.Getter;

/**
 * @program: open-his
 * @description: 返回结果的枚举
 * @author: lzy
 * @create: 2020-09-25 18:45
 **/
@Getter
public enum ResultEnum {
    /**
     * 返回结果枚举
     */
    SUCCESS(20000,"操作成功!"),
    ERROR(40000,"操作失败!"),
    DATA_NOT_FOUND(40001,"数据查询失败!"),
    PARAMS_NULL(40002,"参数不能为空!"),

    NOT_LOGIN(40003,"当前账号未登录!"),
    PARAMS_ERROR(40005, "参数不合法！"),
    /**
     * 用户类型
     * 0 管理员
     * 1 普通用户
     */
    USER_ADMIN(0,"管理员"),
    USER_NORMAL(1,"普通用户"),

    /**
     * 返回的额校验码
     * 0 检验通过
     * 1校验未通过
     */
    UNIQUE(0,"校验未通过"),
    NOT_UNIQUE(1,"检验通过"),

    /**
     * 有效的状态码
     * 0 无效
     * 1 有效1
     */
    STATUS_TRUE(1,"有效的状态码"),
    STATUS_FALSE(0,"无效的状态码"),

    /**
     * 逻辑删除状态码
     */
    DELETED(1,"已删除"),
    NOT_DELETED(0,"未删除"),

    /**
     * 入库单状态
     * 1未提交2待审核 3审核通过
     * 4审核失败 5作废 6 入库成功
     */
    STOCK_PURCHASE_STATUS_1(1,"未提交"),
    STOCK_PURCHASE_STATUS_2(2,"待审核"),
    STOCK_PURCHASE_STATUS_3(3,"审核通过"),
    STOCK_PURCHASE_STATUS_4(4,"审核失败"),
    STOCK_PURCHASE_STATUS_5(5,"作废"),
    STOCK_PURCHASE_STATUS_6(6,"入库成功"),

    /**
     * 入库状态
     * 0 未入库
     * 1 已入库
     */
    STOCK_STATUS(0,"未入库"),
    NOT_STOCK_STATUS(1,"已入库"),

    /**
     * 排班状态
     * 0 未排班
     * 1 已排班
     */

    SCHEDULING_FLAG_TRUE(0,"未排班"),
    SCHEDULING_FLAG_FALSE(1,"已排班"),

    /**
     * 是否已经完善信息
     * 0 否
     * 1 是
     */
    IS_FINAL_FALSE(0,"信息没有完善"),
    IS_FINAL_TRUE(1,"信息已经完善"),

    /**
     * 挂号状态
     */
    REG_STATUS_0(0,"待支付"),
    REG_STATUS_1(1,"待就诊"),
    REG_STATUS_2(2,"就诊中"),
    REG_STATUS_3(3,"就诊完成"),
    REG_STATUS_4(4,"已退号"),
    REG_STATUS_5(5,"已作废"),

    /**
     * 处方类型
     */
    CO_TYPE_MEDICINES(0,"错误"),
    CO_TYPE_CHECK(1,"正确"),

    /**
     * 支付单状态状态，0未支付,1已支付，2支付超时
     */
    ORDER_STATUS_0(0,"未支付"),
    ORDER_STATUS_1(1,"已支付"),
    ORDER_STATUS_2(2,"支付超时"),

    /**
     * 订单子项目支付状态
     * 0未支付，1已支付，2，已退费  3，已完成
     */
    ORDER_DETAILS_STATUS_0(0,"未支付"),
    ORDER_DETAILS_STATUS_1(1,"已经支付"),
    ORDER_DETAILS_STATUS_2(2,"已经退费"),
    ORDER_DETAILS_STATUS_3(3,"支付完成"),

    /**
     * 检查状态  0 检查中   1检查完成
     */
    RESULT_STATUS_0(0,"检查中"),
    RESULT_STATUS_1(1,"检查完成"),

    /**
     * 退费单状态，订单状态0未退费  1 退费成功 2退费失败
     */
    ORDER_BACKFEE_STATUS_0(0,"未退费"),
    ORDER_BACKFEE_STATUS_1(1,"退费成功"),
    ORDER_BACKFEE_STATUS_2(2,"退费失败"),

    /**
     * 支付类型
     */
    PAY_TYPE_0(0,"现金"),
    PAY_TYPE_1(1,"支付宝支付");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


}
