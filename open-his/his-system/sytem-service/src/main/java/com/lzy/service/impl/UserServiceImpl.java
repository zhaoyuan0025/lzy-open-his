package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.mapper.UserMapper;
import com.lzy.domain.User;
import com.lzy.service.UserService;
/**
 * @author lzy
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据手机号查询用户
     * @param phone 手机号
     * @return
     */
    @Override
    public User queryUserByPhone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //判断手机号是否相等
        queryWrapper.eq(User.COL_PHONE,phone);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 根据用户编号查询用户
     * @param userId 用户编号
     * @return
     */
    @Override
    public User getOne(Long userId) {
        //直接通过id查询
        return userMapper.selectById(userId);
    }
}
