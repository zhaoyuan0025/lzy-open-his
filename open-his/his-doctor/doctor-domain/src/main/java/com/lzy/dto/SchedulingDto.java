package com.lzy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: 尚学堂 雷哥
 * 封装页面需要的数据
 */
@ApiModel(value="com-lzy-dto-SchedulingDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingDto implements Serializable {

    private Long userId;

    private Long deptId;

    private String subsectionType;//上午1  下午2  晚上3

    private Collection<String> schedulingType;//存放周一到周日的subsectionType时间段 是门诊还是急诊的数据


    //存放星期值班的记录 key 指日期    周一到周日的日期字符串   value 有值就1  2   没有值就""
    @JsonIgnore
    private Map<String,String> record;

    /**
     * 构造器
     * @param userId
     * @param deptId
     * @param subsectionType
     * @param record
     */
    public SchedulingDto(Long userId, Long deptId, String subsectionType, Map<String, String> record) {
        this.userId = userId;
        this.deptId = deptId;
        this.subsectionType = subsectionType;
        this.record = record;
    }
}
