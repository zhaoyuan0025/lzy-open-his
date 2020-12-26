package com.lzy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.constants.Constants;
import com.lzy.domain.Dept;
import com.lzy.dto.DeptDTO;
import com.lzy.mapper.DeptMapper;
import com.lzy.service.DeptService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @program: open-his
 * @description: 部门/科室的接口实现类
 * @author: lzy
 * @create: 2020-12-24 00:43
 **/
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public DataGridView listPage(DeptDTO deptDto) {
        Page<Dept> page = new Page<>(deptDto.getPageNum(),deptDto.getPageSize());
        //构造查询条件
        QueryWrapper<Dept> qw = new QueryWrapper<>();
        //模糊查询
        qw.like(StringUtils.isNotBlank(deptDto.getDeptName()),Dept.COL_DEPT_NAME,deptDto.getDeptName());
        qw.eq(StringUtils.isNotBlank(deptDto.getStatus()),Dept.COL_STATUS,deptDto.getStatus());
        qw.ge(deptDto.getBeginTime()!=null, Dept.COL_CREATE_TIME,deptDto.getBeginTime());
        //时间
        qw.le(deptDto.getEndTime()!=null,Dept.COL_CREATE_TIME,deptDto.getEndTime());
        qw.orderByAsc(Dept.COL_ORDER_NUM);
        this.deptMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Dept> listAll() {
        QueryWrapper<Dept> qw = new QueryWrapper<>();
        qw.eq(Dept.COL_STATUS, Constants.STATUS_TRUE);
        qw.orderByAsc(Dept.COL_ORDER_NUM);
        return deptMapper.selectList(qw);
    }

    /**
     * 通过ID查询
     * @param deptId
     * @return
     */
    @Override
    public Dept getOne(Long deptId) {
        return deptMapper.selectById(deptId);
    }

    /**
     * 添加
     * @param deptDto
     * @return
     */
    @Override
    public int addDept(DeptDTO deptDto) {
        Dept dept = new Dept();
        BeanUtil.copyProperties(deptDto,dept);
        dept.setCreateBy(deptDto.getSimpleUser().getUserName());
        dept.setCreateTime(DateUtil.date());
//        dept.setDeleted(0);
        return deptMapper.insert(dept);
    }

    /**
     * 更新
     * @param deptDto
     * @return
     */
    @Override
    public int updateDept(DeptDTO deptDto) {
        Dept dept = new Dept();
        BeanUtil.copyProperties(deptDto,dept);
        dept.setUpdateBy(deptDto.getSimpleUser().getUserName());
        dept.setUpdateTime(DateUtil.date());
        return deptMapper.updateById(dept);
    }

    /**
     * 删除
     * @param deptIds
     * @return
     */
    @Override
    public int deleteDeptByIds(Long[] deptIds) {
        List<Long> asList = Arrays.asList(deptIds);
        if(null!=asList && asList.size()>0){
            return deptMapper.deleteBatchIds(asList);
        }
        return 0;
    }
}
