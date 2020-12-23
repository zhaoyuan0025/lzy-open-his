package com.lzy.service.impl;

import com.lzy.domain.Dept;
import com.lzy.dto.DeptDTO;
import com.lzy.mapper.DeptMapper;
import com.lzy.service.DeptService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<Dept> listAll() {
        return null;
    }

    @Override
    public Dept getOne(Long deptId) {
        return null;
    }

    @Override
    public int addDept(DeptDTO deptDto) {
        return 0;
    }

    @Override
    public int updateDept(DeptDTO deptDto) {
        return 0;
    }

    @Override
    public int deleteDeptByIds(Long[] deptIds) {
        return 0;
    }
}
