package com.lzy.service;

import com.lzy.domain.DictType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzy.dto.DictTypeDto;
import com.lzy.vo.DataGridView;

/**
 * @author Administrator
 */
public interface DictTypeService{

    /**
     * 分页查询字典类型
     * @param dictTypeDto
     * @return
     */
    DataGridView listPage(DictTypeDto dictTypeDto);

    /**
     * 查询所有字典的类型
     * @return
     */
    DataGridView list();

    /**
     * 检查字典类型是否存在
     * @param dictId
     * @param dictType
     * @return
     */
    Boolean checkDictTypeUnique(Long dictId,String dictType);

    /**
     * 添加新的字典类型
     * @param dictTypeDto
     * @return
     */
    int insert(DictTypeDto dictTypeDto);

    /**
     * 修改
     * @param dictTypeDto
     * @return
     */
    int update(DictTypeDto dictTypeDto);

    /**
     * 通过id删除
     * @param dictId
     * @return
     */
    int deleteDictTypeById(Long[] dictId);

    /**
     * 通过id查询
     * @param dictId
     * @return
     */
    DictType selectById(Long dictId);
}
