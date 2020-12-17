package com.lzy.controller.system;

import com.lzy.dto.OperLogDTO;
import com.lzy.service.OperLogService;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: open-his
 * @description: 日志数据
 * @author: lzy
 * @create: 2020-12-17 00:34
 **/
@Log4j2
@RestController
@RequestMapping("/log")
public class OperLogController {

    @Autowired
    private OperLogService operLogService;

    /**
     * 分页查询
     * @param operLogDTO
     * @return
     */
    @GetMapping("/listForPage")
    public AjaxResult listForPage(OperLogDTO operLogDTO){
        DataGridView dataGridView = operLogService.listForPage(operLogDTO);
        return AjaxResult.success("查询成功！",dataGridView.getData(),dataGridView.getTotal());
    }

    /**
     * 删除
     */
    @DeleteMapping("/deleteOperLogByIds/{infoIds}")
    public AjaxResult deleteOperLogByIds(@PathVariable Long[] infoIds){
        Integer integer = this.operLogService.deleteOperLogByIds(infoIds);
        return AjaxResult.toAjax(integer);
    }

    /**
     * 清空删除
     */
    @DeleteMapping("/clearAllOperLog")
    public AjaxResult clearAllOperLog(){
        return AjaxResult.toAjax(this.operLogService.clearAllOperLog());
    }



}
