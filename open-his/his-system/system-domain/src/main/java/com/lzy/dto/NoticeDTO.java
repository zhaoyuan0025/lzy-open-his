package com.lzy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
* @Author: 尚学堂 雷哥
*/
@ApiModel(value="com-lzy-dto-NoticeDTO")
@Data
//@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO implements Serializable {
    private static final long serialVersionUID = -3574527007120832527L;
    /**
     * 公告ID
     */
    @ApiModelProperty(value="公告ID")
    private Integer id;

    /**
     * 公告标题
     */
    @NotBlank(message = "公告标题不能为空")
    @ApiModelProperty(value="公告标题")
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    @NotBlank(message = "公告类型不能为空")
    @ApiModelProperty(value="公告类型（1通知 2公告）")
    private String noticeType;

    /**
     * 公告内容
     */
    @NotBlank(message = "公告内容不能为空")
    @ApiModelProperty(value="公告内容")
    private String noticeContent;

    /**
     * 公告状态（0正常 1停用）
     */
    @NotBlank(message = "公告状态不能为空")
    @ApiModelProperty(value="公告状态（0正常 1停用）")
    private String status;

    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者")
    private String createBy;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}