package com.lzy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzy.domain.SimpleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: open-his
 * @description: 基础的数据传输类
 * @author: lzy
 * @create: 2020-09-25 19:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto implements Serializable {

    /**
     * 页码 默认1
     */
    private Integer pageNum = 1;

    /**
     * 每页显示条数 默认10
     */
    private Integer pageSize = 10;

    /**
     * 当前操作对象
     */
    private SimpleUser simpleUser;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
