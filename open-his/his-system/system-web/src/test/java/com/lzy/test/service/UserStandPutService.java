package com.lzy.test.service;

/**
 * @program: open-his
 * @description: 用户的停留时长接口
 * @author: lzy
 * @create: 2020-12-18 18:21
 **/
public interface UserStandPutService {

    /**
     * 上报用户停留时间至 redis
     * @param userId     人员id
     * @param standStart 开始时间戳
     * @param standEnd   结束时间戳
     */
//    void putUserStand(String userId, Long standStart, Long standEnd);
}
