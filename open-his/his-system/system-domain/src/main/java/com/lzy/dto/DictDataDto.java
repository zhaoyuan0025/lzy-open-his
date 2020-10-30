package com.lzy.dto;

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

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: open-his
 * @description: 数据传输对象
 * @author: lzy
 * @create: 2020-10-30 19:02
 **/
@ApiModel(value="com-lzy-domain-DictDataDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DictDataDto extends BaseDto {
    /**
     * 字典编码
     */
    @ApiModelProperty(value="字典编码")
    private Long dictCode;

    /**
     * 字典排序
     */
    @ApiModelProperty(value="字典排序")
    @NotNull(message = "排序码不能为空！")
    private Integer dictSort;

    /**
     * 字典标签
     */
    @ApiModelProperty(value="字典标签")
    @NotNull(message = "字典标签不能为空！")
    private String dictLabel;

    /**
     * 字典键值
     */
    @ApiModelProperty(value="字典键值")
    @NotNull(message = "字典键值不能为空")
    private String dictValue;

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
    @NotNull(message = "状态不能为空！")
    private String status;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 创建者
     */
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
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;
}
