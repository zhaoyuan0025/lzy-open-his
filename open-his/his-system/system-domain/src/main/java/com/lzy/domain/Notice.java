package com.lzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
* @Author: 尚学堂 雷哥
*/

/**
    * 通知公告表
    */
@ApiModel(value="com-lzy-domain-Notice")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_notice")
@Builder
public class Notice extends BaseEntity {
    /**
     * 公告ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="公告ID")
    private Integer id;

    /**
     * 公告标题
     */
    @TableField(value = "notice_title")
    @ApiModelProperty(value="公告标题")
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    @TableField(value = "notice_type")
    @ApiModelProperty(value="公告类型（1通知 2公告）")
    private String noticeType;

    /**
     * 公告内容
     */
    @TableField(value = "notice_content")
    @ApiModelProperty(value="公告内容")
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    @TableField(value = "status")
    @ApiModelProperty(value="公告状态（0正常 1关闭）")
    private String status;

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

    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除 0否1是")
    private Integer deleted;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    public static final String COL_NOTICE_ID = "id";

    public static final String COL_NOTICE_TITLE = "notice_title";

    public static final String COL_NOTICE_TYPE = "notice_type";

    public static final String COL_NOTICE_CONTENT = "notice_content";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DELETED = "deleted";

    public static final String COL_REMARK = "remark";
}