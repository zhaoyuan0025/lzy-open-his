package com.lzy.service;

import com.lzy.domain.LoginInfo;
import com.lzy.dto.LoginInfoDTO;
import com.lzy.vo.DataGridView;

/**
 * @program: open-his
 * @description: 系统的访问记录的service接口
 * @author: lzy
 * @create: 2020-12-17 00:46
 **/
public interface LoginInfoService {

    /**
     * 添加
     *
     * @param loginInfo
     * @return
     */
    int insertLoginInfo(LoginInfo loginInfo);

    /**
     * 分页查询
     *
     * @param loginInfoDTO
     * @return
     */
    DataGridView listForPage(LoginInfoDTO loginInfoDTO);

    /**
     * 删除登陆日志
     *
     * @param infoIds
     * @return
     */
    int deleteLoginInfoByIds(Long[] infoIds);

    /**
     * 清空登陆日志
     *
     * @return
     */
    int clearLoginInfo();


}
