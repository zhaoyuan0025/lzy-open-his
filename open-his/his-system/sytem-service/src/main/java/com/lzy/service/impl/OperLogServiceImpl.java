package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.domain.OperLog;
import com.lzy.dto.OperLogDTO;
import com.lzy.mapper.OperLogMapper;
import com.lzy.service.OperLogService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName OperLogServiceImpl
 * @Description
 * @Author 刘少
 * @Date 2020/12/13 22:06
 * @Version 1.0
 */
@Slf4j
@Service
public class OperLogServiceImpl implements OperLogService {

    @Autowired
    private OperLogMapper operLogMapper;

    /**
      * 功能描述: 添加
      * params: [operLog]
      * @return : void
      * @author : lzy
      * @date : 2020/12/13 22:25
    */
    @Override
    public void insertOperLog(OperLog operLog) {
        operLogMapper.insert(operLog);
    }

    /**
      * 功能描述: 分页查询
      * params: [OperLogDTO]
      * @return : com.lzy.vo.DataGridView
      * @author : lzy
      * @date : 2020/12/13 22:26
    */
    @Override
    public DataGridView listForPage(OperLogDTO operLogDTO) {
        Page<OperLog> page = new Page<>(operLogDTO.getPageNum(),operLogDTO.getPageSize());
        //构造查询的条件
        QueryWrapper<OperLog> qw = new QueryWrapper<>();
        //模糊查询的条件
        qw.like(StringUtils.isNotBlank(operLogDTO.getOperName()),OperLog.COL_OPER_NAME,operLogDTO.getOperName());
        qw.like(StringUtils.isNotBlank(operLogDTO.getTitle()), OperLog.COL_TITLE, operLogDTO.getTitle());
        //是否可用
        qw.eq(StringUtils.isNotBlank(operLogDTO.getBusinessType()), OperLog.COL_BUSINESS_TYPE, operLogDTO.getBusinessType());
        qw.eq(StringUtils.isNotBlank(operLogDTO.getStatus()), OperLog.COL_STATUS, operLogDTO.getStatus());
        //时间的查询
        qw.ge(null != operLogDTO.getBeginTime(), OperLog.COL_OPER_TIME, operLogDTO.getBeginTime());
        qw.le(null != operLogDTO.getEndTime(), OperLog.COL_OPER_TIME, operLogDTO.getEndTime());
        //排序
        qw.orderByDesc(OperLog.COL_OPER_TIME);
        this.operLogMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
      * 功能描述: 删除
      * params: [ids]
      * @return : java.lang.Integer
      * @author : lzy
      * @date : 2020/12/13 22:35
    */
    @Override
    public Integer deleteOperLogByIds(Long[] ids) {
        if(null != ids && ids.length>0){
            //将数组转化集合
            List<Long> list = Arrays.asList(ids);
            return operLogMapper.deleteBatchIds(list);
        }
        return 0;
    }

    /**
      * 功能描述: 全部删除
      * params: []
      * @return : java.lang.Integer
      * @author : lzy
      * @date : 2020/12/13 22:36
    */
    @Override
    public Integer clearAllOperLog() {
        return operLogMapper.delete(null);
    }
}
