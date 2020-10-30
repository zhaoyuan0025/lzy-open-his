package com.lzy.controller.system;

import com.lzy.dto.DictTypeDto;
import com.lzy.service.DictTypeService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @program: open-his
 * @description: 字典类型的web层
 * @author: lzy
 * @create: 2020-10-12 19:12
 **/
@RestController
@RequestMapping("/dict")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    /**
     * 分页查询数据
     * @param dictTypeDto
     * @return
     */
    @GetMapping("/listForPage")
    public AjaxResult listForPage(DictTypeDto dictTypeDto){
        DataGridView dataGridView = dictTypeService.listPage(dictTypeDto);
        return AjaxResult.success("查询成功",dataGridView.getData(),dataGridView.getTotal());
    }

    /**
     * 添加
     * @param dictTypeDto
     * @return
     */
    @PostMapping("/addDictType")
    public AjaxResult addDictType(@Validated DictTypeDto dictTypeDto){
        //通过id去判断字典类型存不存在，不存在就添加
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return AjaxResult.fail("新增字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        //添加人
        dictTypeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        //添加
        return AjaxResult.toAjax(this.dictTypeService.insert(dictTypeDto));
    }

    /**
     * 更新
     * @param dictTypeDto
     * @return
     */
    @PostMapping("/updateDictType")
    public AjaxResult updateDictType(@Validated DictTypeDto dictTypeDto){
        //通过id去判断字典类型存不存在，不存在就添加
        if (dictTypeService.checkDictTypeUnique(dictTypeDto.getDictId(), dictTypeDto.getDictType())) {
            return AjaxResult.fail("更新字典【" + dictTypeDto.getDictName() + "】失败，字典类型已存在");
        }
        //添加人
        dictTypeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        //添加
        return AjaxResult.toAjax(this.dictTypeService.update(dictTypeDto));
    }

    /**
     * 通过id查询
     * @param dictId
     * @return
     */
    @GetMapping("/getDictType/{dictId}")
    public AjaxResult getDictType(@PathVariable @Validated @NotNull(message = "传入的字典ID不能为空")Long dictId){
        return AjaxResult.success("查询成功",this.dictTypeService.selectById(dictId));
    }

    /**
     * 批量删除
     * @param dictIds
     * @return
     */
    @DeleteMapping("/deleteByIds/{dictIds}")
    public AjaxResult deleteByIds(@PathVariable @Validated @NotNull(message = "传入的字典ID不能为空")Long[] dictIds){
        return AjaxResult.success("删除成功",this.dictTypeService.deleteDictTypeById(dictIds));
    }

    /**
     * 查询所有可用的类型
     * @return
     */
    @GetMapping("/selectAllDictType")
    public AjaxResult selectAllDictType(){
        return AjaxResult.success("查询成功"+this.dictTypeService.list());
    }

}
