package com.lzy.service;


import com.lzy.domain.DictData;
import com.lzy.dto.DictDataDto;
import com.lzy.vo.DataGridView;

import java.util.List;

/**
 * 数据字典的接口
 * @author Administrator
 *
 */
public interface DictDataService{

    /**
     * 分页查询字典数据类型
     * @param dictDataDto
     * @return
     */
    DataGridView listPage(DictDataDto dictDataDto);

    /**
     * 添加
     * @param dictDataDto
     * @return
     */
    int insert(DictDataDto dictDataDto);

    /**
     * 修改
     * @param dictDataDto
     * @return
     */
    int update(DictDataDto dictDataDto);

    /**
     * 批量删除
     * @param dictCodeIds
     * @return
     */
    int deleteByIds(Long[] dictCodeIds);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 通过字典类型查询数据
     * @param dictType
     * @return
     */
    List<DictData> selectDictDataByDictType(String dictType);

    /**
     * 通过id查询字典类型的数据
     * @param dictId
     * @return
     */
    DictData selectById(Long dictId);

}
