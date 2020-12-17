package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.domain.LoginInfo;
import com.lzy.dto.LoginInfoDTO;
import com.lzy.mapper.LoginInfoMapper;
import com.lzy.service.LoginInfoService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @program: open-his
 * @description: service接口的实现类
 * @author: lzy
 * @create: 2020-12-17 00:49
 **/
@Slf4j
@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Autowired
    private LoginInfoMapper loginInfoMapper;

    /**
     * 添加
     * @param loginInfo
     * @return
     */
    @Override
    public int insertLoginInfo(LoginInfo loginInfo) {
        int insert = loginInfoMapper.insert(loginInfo);
        return insert;
    }

    /**
     * 分页查询
     * @param loginInfoDTO
     * @return
     */
    @Override
    public DataGridView listForPage(LoginInfoDTO loginInfoDTO) {
        Page<LoginInfo> page=new Page<>(loginInfoDTO.getPageNum(),loginInfoDTO.getPageSize());
        QueryWrapper<LoginInfo> qw=new QueryWrapper<>();
        //匹配模糊查询的条件
        qw.like(StringUtils.isNotBlank(loginInfoDTO.getUserName()),LoginInfo.COL_USER_NAME,loginInfoDTO.getUserName());
        qw.like(StringUtils.isNotBlank(loginInfoDTO.getIpAddr()),LoginInfo.COL_IP_ADDR,loginInfoDTO.getIpAddr());
        qw.like(StringUtils.isNotBlank(loginInfoDTO.getLoginAccount()),LoginInfo.COL_LOGIN_ACCOUNT,loginInfoDTO.getLoginAccount());
        //查询的条件
        qw.eq(StringUtils.isNotBlank(loginInfoDTO.getLoginStatus()),LoginInfo.COL_LOGIN_STATUS,loginInfoDTO.getLoginStatus());
        qw.eq(StringUtils.isNotBlank(loginInfoDTO.getLoginType()),LoginInfo.COL_LOGIN_TYPE,loginInfoDTO.getLoginType());
        //根据时间段查找
        qw.ge(null!= loginInfoDTO.getBeginTime(), LoginInfo.COL_LOGIN_TIME, loginInfoDTO.getBeginTime());
        qw.le(null!= loginInfoDTO.getEndTime(), LoginInfo.COL_LOGIN_TIME, loginInfoDTO.getEndTime());
        //排序
        qw.orderByDesc(LoginInfo.COL_LOGIN_TIME);
        this.loginInfoMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());

    }

    /**
     * 删除
     * @param infoIds
     * @return
     */
    @Override
    public int deleteLoginInfoByIds(Long[] infoIds) {
        List<Long> longs = Arrays.asList(infoIds);
        //判断
        if(longs.size()>0){
            int batchIds = loginInfoMapper.deleteBatchIds(longs);
            return batchIds;
        }
        return 0;
    }

    /**
     * 删除所有
     * @return
     */
    @Override
    public int clearLoginInfo() {
        return loginInfoMapper.delete(null);
    }
}
