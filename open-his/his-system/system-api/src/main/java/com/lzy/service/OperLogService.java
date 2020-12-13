package com.lzy.service;

import com.lzy.domain.OperLog;
import com.lzy.dto.OperLogDTO;
import com.lzy.vo.DataGridView;

/**
 * @ClassName OperLogService
 * @Description 业务层接口
 * @Author 刘少
 * @Date 2020/12/13 22:05
 * @Version 1.0
 */

public interface OperLogService  {

    /**
    * 功能描述:添加
    * @return : void
    * @author : lzy
    * @date : 2020/12/13 22:19
    */
    public void insertOperLog(OperLog operLog);

    /**
    * 功能描述:分页查询
    * @return : com.lzy.vo.DataGridView
    * @author : lzy
    * @date : 2020/12/13 22:20
    */
    DataGridView listForPage(OperLogDTO operLogDTO);

    /**
      * 功能描述: 根据id删除数据
      * params: [ids]
      * @return : java.lang.Integer
      * @author : lzy
      * @date : 2020/12/13 22:23
    */
    Integer deleteOperLogByIds(Long[] ids);

    /**
      * 功能描述: 删除所有日志
      * params: []
      * @return : java.lang.Integer
      * @author : lzy
      * @date : 2020/12/13 22:24
    */
    Integer clearAllOperLog();
}
