package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: open-his
 * @description: 数据传输对象的dto
 * @author: lzy
 * @create: 2020-12-24 00:34
 **/
@ApiModel(value="com-lzy-dto-DeptDTO")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO extends BaseDto {

    /**
     * 部门科室id
     */
    @ApiModelProperty(value="部门科室id")
    private Long deptId;

    /**
     * 部门名称
     */
    @NotNull(message = "科室名称不能为空")
    @ApiModelProperty(value="部门名称")
    private String deptName;

    /**
     * 挂号编号
     */
    @NotNull(message = "挂号编号不能为空")
    @ApiModelProperty(value="挂号编号")
    private Integer regNumber;

    /**
     * 科室编号
     */
    @ApiModelProperty(value="科室编号")
    @NotNull(message = "科室编号不能为空")
    private String deptNumber;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value="显示顺序")
    @NotNull(message = "排序码不能为空")
    private Integer orderNum;

    /**
     * 负责人
     */
    @ApiModelProperty(value="负责人")
    private String deptLeader;

    /**
     * 联系电话
     */
    @ApiModelProperty(value="联系电话")
    private String leaderPhone;

    /**
     * 部门状态（0正常 1停用）
     */
    @ApiModelProperty(value="部门状态（0正常 1停用）")
    @NotNull(message = "科室状态不能为空")
    private String status;

}
