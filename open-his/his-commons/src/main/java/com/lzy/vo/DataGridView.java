package com.lzy.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: open-his
 * @description: 分页的数据传输对象
 * @author: lzy
 * @create: 2020-10-08 16:54
 **/
@ApiModel(value="com-lzy-vo-DataGridView")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGridView implements Serializable {
    /**
     * 数据总条数
     */
    private Long total;

    /**
     * 传输的数据
     */
    private List<?> data;

}
