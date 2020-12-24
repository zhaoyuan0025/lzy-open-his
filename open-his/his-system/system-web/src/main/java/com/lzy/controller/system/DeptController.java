package com.lzy.controller.system;

import com.lzy.aspectj.annotation.Log;
import com.lzy.aspectj.enums.BussinessType;
import com.lzy.domain.Dept;
import com.lzy.dto.DeptDTO;
import com.lzy.service.DeptService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @program: open-his
 * @description: 部门科室管理
 * @author: lzy
 * @create: 2020-12-25 01:18
 **/
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 分页查询
     */
    @GetMapping("/listDeptForPage")
    public AjaxResult listDeptForPage(DeptDTO deptDto) {
        DataGridView gridView = this.deptService.listPage(deptDto);
        return AjaxResult.success("查询成功", gridView.getData(), gridView.getTotal());
    }

    /**
     * 不分页面查询有效的
     */
    @GetMapping("/selectAllDept")
    public AjaxResult selectAllDept() {
        List<Dept> lists = this.deptService.listAll();
        return AjaxResult.success(lists);
    }

    /**
     * 查询一个
     */
    @GetMapping("/getDeptById/{deptId}")
    public AjaxResult getDeptById(@PathVariable @Validated @NotEmpty(message = "科室ID为空") Long deptId) {
        Dept dept = this.deptService.getOne(deptId);
        return AjaxResult.success(dept);
    }

    /**
     * 添加
     */
    @PostMapping("/addDept")
    @Log(title = "科室管理", businessType = BussinessType.INSERT)
    public AjaxResult addDept(@Validated DeptDTO deptDto) {
        deptDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.deptService.addDept(deptDto));
    }

    /**
     * 修改
     */
    @Log(title = "科室管理", businessType = BussinessType.UPDATE)
    @PutMapping("/updateDept")
    public AjaxResult updateDept(@Validated DeptDTO deptDto) {
        deptDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.deptService.updateDept(deptDto));
    }

    /**
     * 删除
     */
    @Log(title = "科室管理", businessType = BussinessType.DELETE)
    @DeleteMapping("/deleteDeptByIds/{deptIds}")
    public AjaxResult delete(@PathVariable @Validated @NotEmpty(message = "科室ID为空") Long[] deptIds) {
        return AjaxResult.toAjax(this.deptService.deleteDeptByIds(deptIds));
    }

}
