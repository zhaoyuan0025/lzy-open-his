package com.lzy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.constants.Constants;
import com.lzy.dto.DictTypeDto;
import com.lzy.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.mapper.DictTypeMapper;
import com.lzy.domain.DictType;
import com.lzy.service.DictTypeService;
/**
 * @author Administrator
 */
@Service
public class DictTypeServiceImpl implements DictTypeService{

    @Autowired
    private DictTypeMapper dictTypeMapper;

    /**
     * 分页查询字典类型
     * @param dictTypeDto
     * @return
     */
    @Override
    public DataGridView listPage(DictTypeDto dictTypeDto) {
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        //分页的参数
        Page<DictType> page = new Page<>(dictTypeDto.getPageNum(),dictTypeDto.getPageSize());
        //构造分页查询的条件
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictName()),DictType.COL_DICT_NAME,dictTypeDto.getDictName());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictType()),DictType.COL_DICT_TYPE,dictTypeDto.getDictType());
        qw.eq(StringUtils.isNotBlank(dictTypeDto.getStatus()),DictType.COL_STATUS,dictTypeDto.getStatus());
        qw.ge(null!=dictTypeDto.getBeginTime(), DictType.COL_CREATE_TIME,dictTypeDto.getBeginTime());
        qw.le(null!=dictTypeDto.getEndTime(), DictType.COL_CREATE_TIME,dictTypeDto.getEndTime());


        this.dictTypeMapper.selectPage(page,qw);
        //将分页的对象返回
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 查询所有的字典类型
     * @return
     */
    @Override
    public DataGridView list() {
        QueryWrapper<DictType> qw = new QueryWrapper<>();

        //只查询可用的
        qw.eq(DictType.COL_STATUS, Constants.STATUS_TRUE);
        return new DataGridView(null,dictTypeMapper.selectList(qw));
    }

    /**
     * 检查字典类型是否存在
     * @param dictId
     * @param dictType
     * @return
     */
    @Override
    public Boolean checkDictTypeUnique(Long dictId, String dictType) {
        dictId = (dictId == null)? -1L:dictId;
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        qw.eq(DictType.COL_DICT_TYPE,dictType);
        //查询出来
        DictType selectOne = dictTypeMapper.selectOne(qw);
        //判断
        if(null != selectOne && dictId.longValue()!=selectOne.getDictId().longValue()){
            //说明字典
            return true;
        }
        return null;
    }


    /**
     * 插入
     * @param dictTypeDto
     * @return
     */
    @Override
    public int insert(DictTypeDto dictTypeDto) {
        DictType dictType = new DictType();
        //使用hutool工具类拷贝
        BeanUtil.copyProperties(dictTypeDto,dictType);
        //设置创建者，创建时间
        dictType.setCreateBy(dictTypeDto.getSimpleUser().getUserName());
        dictType.setCreateTime(DateUtil.date());
        return dictTypeMapper.insert(dictType);
    }

    /**
     * 更新
     * @param dictTypeDto
     * @return
     */
    @Override
    public int update(DictTypeDto dictTypeDto) {
        DictType dictType = new DictType();
        //使用hutool工具类拷贝
        BeanUtil.copyProperties(dictTypeDto,dictType);
        //设置修改人
        dictType.setUpdateBy(dictTypeDto.getSimpleUser().getUserName());
        //通过id修改
        return dictTypeMapper.updateById(dictType);
    }

    /**
     * 删除 批量
     * @param dictId
     * @return
     */
    @Override
    public int deleteDictTypeById(Long[] dictId) {
        //将数组转化为集合
        List<Long> ids = Arrays.asList(dictId);
        if(null != ids && ids.size()>0){
            //删除
            return dictTypeMapper.deleteBatchIds(ids);
        }
        return -1;
    }

    /**
     * 通过id查询
     * @param dictId
     * @return
     */
    @Override
    public DictType selectById(Long dictId) {
        return this.dictTypeMapper.selectById(dictId);
    }
}
