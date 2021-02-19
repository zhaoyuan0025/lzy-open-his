package com.lzy.service;

import com.lzy.domain.User;
import com.lzy.dto.UserDTO;
import com.lzy.vo.DataGridView;

import java.util.List;

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

     /**
      * 分页查询用户
      * @param userDto
      * @return
      */
     DataGridView listUserForPage(UserDTO userDto);

     /**
      * 添加用户
      * @param userDto
      * @return
      */
     int addUser(UserDTO userDto);

     /**
      * 修改用户
      * @param userDto
      * @return
      */
     int updateUser(UserDTO userDto);

     /**
      * 删除用户
      * @param userIds
      * @return
      */
     int deleteUserByIds(Long[] userIds);

     /**
      * 查询所有可用的用户
      * @return
      */
     List<User> getAllUsers();

     /**
      * 重置用户密码
      * @param userIds
      */
     void resetPassWord(Long[] userIds);

 }
