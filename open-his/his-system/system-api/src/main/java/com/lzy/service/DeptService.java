package com.lzy.service;

import com.lzy.domain.Dept;
import com.lzy.dto.DeptDTO;
import com.lzy.vo.DataGridView;

import java.util.List;

/**
 * @program: open-his
 * @description: 部门接口
 * @author: lzy
 * @create: 2020-12-24 00:42
 **/
public interface DeptService {

    /**
     * 分页查询
     * @param deptDto
     * @return
     */
    DataGridView listPage(DeptDTO deptDto);

    /**
     * 查询所有有效部门
     * @return
     */
    List<Dept> listAll();

    /**
     * 根据ID查询一个
     * @param deptId
     * @return
     */
    Dept getOne(Long deptId);

    /**
     * 添加一个部门
     * @param deptDto
     * @return
     */
    int addDept(DeptDTO deptDto);

    /**
     * 修改部门
     * @param deptDto
     * @return
     */
    int updateDept(DeptDTO deptDto);

    /**
     * 根据IDS删除部门
     * @param deptIds
     * @return
     */
    int deleteDeptByIds(Long[] deptIds);

}
