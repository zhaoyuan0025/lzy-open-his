package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: open-his
 * @description: 数据传输对象
 * @author: lzy
 * @create: 2020-10-08 16:49
 **/
@ApiModel(value="com-lzy-dto-DictTypeDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictTypeDto extends BaseDto{
    /**
     * 字典主键
     */
    @ApiModelProperty(value="字典主键")
    private Long dictId;

    /**
     * 字典名称
     */
    @ApiModelProperty(value="字典名称")
    @NotNull(message = "字典名称不能为空")
    private String dictName;

    /**
     * 字典类型
     */
    @ApiModelProperty(value="字典类型")
    @NotNull(message = "字典类型不能为空")
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value="状态（0正常 1停用）")
    @NotNull(message = "字典状态不能为空")
    private String status;

    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

}
