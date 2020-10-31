package com.lzy.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.constants.Constants;
import com.lzy.dto.DictDataDto;
import com.lzy.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.security.Key;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.domain.DictData;
import com.lzy.mapper.DictDataMapper;
import com.lzy.service.DictDataService;
/**
 * 字典类型数据的实现类
 * @author Administrator
 */
@Service
public class DictDataServiceImpl  implements DictDataService{

    @Autowired
    private DictDataMapper dictDataMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 分页查询
     * @param dictDataDto
     * @return
     */
    @Override
    public DataGridView listPage(DictDataDto dictDataDto) {
        QueryWrapper<DictData> qw = new QueryWrapper<>();
        //获取分页对象
        Page<DictData> page = new Page<>(dictDataDto.getPageNum(),dictDataDto.getPageSize());
        //设置分页查询的条件
        qw.eq(StringUtils.isNotBlank(dictDataDto.getDictType()),DictData.COL_DICT_TYPE,dictDataDto.getDictType());
        qw.like(StringUtils.isNotBlank(dictDataDto.getDictLabel()), DictData.COL_DICT_LABEL,dictDataDto.getDictLabel());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getStatus()), DictData.COL_STATUS,dictDataDto.getStatus());

        //查询
        this.dictDataMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 添加
     * @param dictDataDto
     * @return
     */
    @Override
    public int insert(DictDataDto dictDataDto) {
        DictData dictData = new DictData();
        BeanUtils.copyProperties(dictDataDto,dictData);
        //设置创建者，创建时间
        dictData.setCreateBy(dictDataDto.getSimpleUser().getUserName());
        dictData.setCreateTime(DateUtil.date());
        return this.dictDataMapper.insert(dictData);
    }

    /**
     * 更新
     * @param dictDataDto
     * @return
     */
    @Override
    public int update(DictDataDto dictDataDto) {
        DictData dictData = new DictData();
        BeanUtils.copyProperties(dictDataDto,dictData);
        //设置修改人
        dictData.setUpdateBy(dictDataDto.getSimpleUser().getUserName());
        return this.dictDataMapper.updateById(dictData);
    }

    /**
     * 批量删除
     * @param dictCodeIds
     * @return
     */
    @Override
    public int deleteByIds(Long[] dictCodeIds) {
        //将数组转化为集合
        List<Long> ids = Arrays.asList(dictCodeIds);
        if(null != ids){
            return this.dictDataMapper.deleteBatchIds(ids);
        }
        return -1;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Long id) {
        return this.dictDataMapper.deleteById(id);
    }

    /**
     * 通过类型名称查询
     *
     * 因为做了缓存，所以可以直接从redis里面取数据，这样就不走数据库了
     * @param dictType
     * @return
     */
    @Override
    public List<DictData> selectDictDataByDictType(String dictType) {
//        QueryWrapper<DictData> qw = new QueryWrapper<>();
//        qw.eq(DictData.COL_DICT_TYPE,dictType);
//        //状态可用的
//        qw.eq(DictData.COL_STATUS, Constants.STATUS_TRUE);
//        return this.dictDataMapper.selectList(qw);

        //组装key
        String key = Constants.DICT_REDIS_PROFIX+dictType;
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //获取值
        String s = opsForValue.get(key);
        List<DictData> dictData = JSON.parseArray(s, DictData.class);
        //将数据返回
        return dictData;
    }

    /**
     * 根据id查询
     * @param dictId
     * @return
     */
    @Override
    public DictData selectById(Long dictId) {
        return this.dictDataMapper.selectById(dictId);
    }
}
