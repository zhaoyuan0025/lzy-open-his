package com.lzy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.constants.Constants;
import com.lzy.domain.User;
import com.lzy.dto.UserDTO;
import com.lzy.mapper.DeptMapper;
import com.lzy.mapper.RoleMapper;
import com.lzy.mapper.UserMapper;
import com.lzy.service.UserService;
import com.lzy.utils.AppMd5Utils;
import com.lzy.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author lzy
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private RoleMapper roleMapper;

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

    /**
     * 分页查询
     * @param userDto
     * @return
     */
    @Override
    public DataGridView listUserForPage(UserDTO userDto) {
        Page<User> page=new Page<>(userDto.getPageNum(), userDto.getPageSize());
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(userDto.getUserName()), User.COL_USER_NAME, userDto.getUserName());
        qw.like(StringUtils.isNotBlank(userDto.getPhone()), User.COL_PHONE, userDto.getPhone());
        qw.eq(StringUtils.isNotBlank(userDto.getStatus()), User.COL_STATUS, userDto.getStatus());
        qw.eq(userDto.getDeptId()!=null, User.COL_DEPT_ID, userDto.getDeptId());
        qw.ge(null!= userDto.getBeginTime(), User.COL_CREATE_TIME, userDto.getBeginTime());
        qw.le(null!= userDto.getEndTime(), User.COL_CREATE_TIME, userDto.getEndTime());
        qw.orderByAsc(User.COL_USER_ID);
        userMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(), page.getRecords());

    }

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    @Override
    public int addUser(UserDTO userDto) {
        User user=new User();
        BeanUtil.copyProperties(userDto,user);
        user.setUserType(Constants.USER_NORMAL);
        String defaultPwd=user.getPhone().substring(5);
        user.setCreateBy(userDto.getSimpleUser().getUserName());
        user.setCreateTime(DateUtil.date());
        user.setSalt(AppMd5Utils.createSalt());
        user.setPassword(AppMd5Utils.md5(defaultPwd,user.getSalt(),2));
        return userMapper.insert(user);
    }

    /**
     * 修改
     * @param userDto
     * @return
     */
    @Override
    public int updateUser(UserDTO userDto) {
        User user=this.userMapper.selectById(userDto.getUserId());
        if(null==user){
            return 0;
        }
        BeanUtil.copyProperties(userDto,user);
        user.setUpdateBy(userDto.getSimpleUser().getUserName());
        return userMapper.updateById(user);
    }

    /**
     * 删除
     * @param userIds
     * @return
     */
    @Override
    public int deleteUserByIds(Long[] userIds) {
        List<Long> ids = Arrays.asList(userIds);
        //根据用户IDS删除sys_role_user里面的数据
        roleMapper.deleteRoleUserByUserIds(ids);
        return userMapper.deleteBatchIds(ids);

    }

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq(User.COL_STATUS, Constants.STATUS_TRUE);
        qw.eq(User.COL_USER_TYPE,Constants.USER_NORMAL);
        qw.orderByAsc(User.COL_USER_ID);
        return userMapper.selectList(qw);

    }

    /**
     * 重置密码
     * @param userIds
     */
    @Override
    public void resetPassWord(Long[] userIds) {
        for (Long userId : userIds) {
            User user=this.userMapper.selectById(userId);
            String defaultPwd="";
            if (user.getUserType().equals(Constants.USER_ADMIN)){
                defaultPwd="123456";
            }else{
                defaultPwd=user.getPhone().substring(5);
            }
            user.setSalt(AppMd5Utils.createSalt());
            user.setPassword(AppMd5Utils.md5(defaultPwd,user.getSalt(),2));
            userMapper.updateById(user);
        }

    }
}
