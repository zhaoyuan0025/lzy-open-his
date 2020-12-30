package com.lzy.test.service.impl;

import com.lzy.test.service.UserStandPutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: open-his
 * @description: 实现类
 * @author: lzy
 * @create: 2020-12-18 18:22
 **/
@Service
public class UserStandPutServiceImpl implements UserStandPutService {

//    private Logger LOGGER = LoggerFactory.getLogger(UserStandPutServiceImpl.class);
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Override
//    public void putUserStand(String userId, Long standStart, Long standEnd) {
//        //处理时间
//        Date startDateTime = DemoDateUtil.parseDateTime(standStart);
//        Date endDateTime = DemoDateUtil.parseDateTime(standEnd);
//        //判断是否是同一天
////        boolean isSameDate = DemoDateUtil.isSameDate(startDateTime, endDateTime);
////        if (isSameDate) {
//        this.sameDateSave(startDateTime, endDateTime, userId);
////        } else {
////            this.doSaveNotSameDay(startDateTime, endDateTime, userId);
////        }
//    }
//
//    /**
//     * 时间在同一天
//     *
//     * @param startDateTime
//     * @param endDateTime
//     */
//    private void sameDateSave(Date startDateTime, Date endDateTime, String userId) {
//        //使用截止时间格式化为 yyyyMMdd
//        //注：因为可能存在跨天所以使用 截止时间
//        String reqDate = DemoDateUtil.formatReqDate(endDateTime);
//        //计算间隔秒数
//        long second = calLastedTime(startDateTime, endDateTime) / 1000;
//        //hash缓存key
//        String hashKey = DemoConstant.USER_STAND_HASH_KEY.concat(reqDate);
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        ops.set();
//        ops.
//        redisCache.hashIncrBy(hashKey, userId, second);
//
//        //list缓存key
//        String listKey = DemoConstant.USER_STAND_LIST_KEY.concat(reqDate);
//        redisCache.zAddByScore(listKey, userId, 0);
//    }
//
//    /**
//     * 时间非同一天
//     *
//     * @param startDateTime
//     * @param endDateTime
//     */
////    private void doSaveNotSameDay(Date startDateTime, Date endDateTime, String userId) {
////        // 计算起点的结束时间 当天的 23:59:59
////        Date startDayEndDate = DemoDateUtil.endOfDay(startDateTime);
////        // 保存前一天的停留时长
////        this.sameDateSave(startDayEndDate, endDateTime, userId);
////        // 保存当天的停留时长
////        this.sameDateSave(startDateTime, startDayEndDate, userId);
////    }
//
//
//    //统计两个日期相间的秒数
//    public long calLastedTime(Date startDate, Date endDate) {
//        long a = endDate.getTime();
//        long b = startDate.getTime();
//        long c = ((a - b) / 1000);
//        return c;
//    }

}
