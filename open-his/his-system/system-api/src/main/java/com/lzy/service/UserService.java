package com.lzy.service;

import com.lzy.domain.User;
 /**
  * @deprecation service接口
  * @author lzy
  */
public interface UserService {

  /**
   * 根据用户手机号查询用户
   * @param phone 手机号
   * @return
   */
 User queryUserByPhone(String phone);

  /**
   * 根据用户id查询用户
   * @param userId 用户编号
   * @return
   */
 User getOne(Long userId);
}
