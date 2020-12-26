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
 * @description: 菜单的数据传输对象 菜单权限
 * @author: lzy
 * @create: 2020-12-27 01:39
 **/
@ApiModel(value = "com-lzy-dto-MenuDto")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class MenuDTO extends BaseDto{
    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID")
    private Long parentId;

    /**
     * 父节点ID集合
     */
    @ApiModelProperty(value = "父节点ID集合")
    private String parentIds;

    /**
     * 菜单名称
     */
    @NotNull(message = "菜单名称不能为空")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @NotNull(message = "菜单类型不能为空")
    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    private String percode;

    /**
     * 路由地址
     */
    @ApiModelProperty(value = "路由地址")
    private String path;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 菜单状态（0正常 1停用）
     */
    @NotNull(message = "菜单状态不能为空")
    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;

}
