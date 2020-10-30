package com.lzy.controller.system;

import com.lzy.domain.DictData;
import com.lzy.dto.DictDataDto;
import com.lzy.service.DictDataService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: open-his
 * @description: 字典类型数据的controller
 * @author: lzy
 * @create: 2020-10-31 01:03
 **/
@RestController
@RequestMapping("/dictData")
public class DictDataController {

    @Autowired
    private DictDataService dictDataService;

    /**
     * 分页查询数据
     * @param dictDataDto
     * @return
     */
    @GetMapping("listForPage")
    public AjaxResult listForPage(DictDataDto dictDataDto){
        DataGridView dataGridView = this.dictDataService.listPage(dictDataDto);;
        return  AjaxResult.success("查询成功!",dataGridView.getData(),dataGridView.getTotal());
    }

    /**
     * 添加
     * @param dictDataDto
     * @return
     */
    @PostMapping("/addDictData")
    public AjaxResult addDictData(@Validated DictDataDto dictDataDto){
        dictDataDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        int i = this.dictDataService.insert(dictDataDto);
        return AjaxResult.toAjax(i);
    }

    /**
     * 更新
     * @param dictDataDto
     * @return
     */
    @PutMapping("updateDictData")
    public AjaxResult updateDictData(@Validated DictDataDto dictDataDto){
        dictDataDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(this.dictDataService.update(dictDataDto));
    }

    /**
     * 根据id查询
     * @param dictId
     * @return
     */
    @GetMapping("getDictData/{dictId}")
    public AjaxResult getDictData(@PathVariable @Validated
                                  @NotNull(message = "字典id不能为空") Long dictId){
        DictData dictData = this.dictDataService.selectById(dictId);
        return AjaxResult.success("查询成功!",dictData);
    }

    /**
     * 批量删除
     * @param dictCodeIds
     * @return
     */
    @DeleteMapping("/deleteByIds/{dictCodeIds}")
    public AjaxResult deleteByIds(@PathVariable @Validated
                                  @NotEmpty(message = "字典id不能为空") Long[] dictCodeIds ) {
        int ids = this.dictDataService.deleteByIds(dictCodeIds);
        return AjaxResult.toAjax(ids);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public AjaxResult deleteById(@PathVariable @NotNull(message = "ID不能为空！") Long id){
        this.dictDataService.deleteById(id);
        return AjaxResult.success("删除成功！");
    }

    /**
     * 根据字典类型查询数据
     * @param dictType
     * @return
     */
    @GetMapping("/getDataByType/{dictType}")
    public AjaxResult getDataByType(@PathVariable @Validated
                                        @NotEmpty(message = "字典类型不能为空") String dictType){
        List<DictData> dictData = this.dictDataService.selectDictDataByDictType(dictType);
        return AjaxResult.success("查询成功!",dictData);
    }
}
