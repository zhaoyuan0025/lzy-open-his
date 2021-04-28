package com.lzy.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: 尚学堂 雷哥
 */
@ApiModel(value="com-lzy-dto-RegistrationQueryDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationQueryDto implements Serializable {
    private Long deptId;//科室ID
    @NotBlank(message = "挂号类型不能为空")
    private String schedulingType;//挂号类型
    @NotBlank(message = "挂号时段不能为空")
    private String subsectionType;//挂号时段
    @NotBlank(message = "挂号日期不能为空")
    private String schedulingDay;//排班时间
}
