package com.lzy.page;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页的参数对象
 * @author 刘少
 */
@Data
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -5047765891149941632L;

    private static final String SORT_ASC = "asc";

    private static final String SORT_DESC = "desc";

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页显示条数
     */
    private Integer pageSize = 10;

    /**
     * 总页数
     */
    private Integer totalPage = 0;

    /**
     * 总条数
     */
    private Integer totalCount = 0;

    /**
     * 数据
     */
    private List<T> list;

    /**
     * 条件参数
     */
    private Map<String, Object> params = new HashMap<>(16);

    /**
     * 排序列
     */
    private String sortColumn="";

    /**
     * 排序方式
     */
    private String sortMethod = "asc";

    /**
     * 获取当前页
     */
    public Integer getCurrentPage() {
        if (currentPage < 1) {
            return 1;
        }
        return this.currentPage;
    }

//    /**
//     * 设置排序列
//     */
//    public void setSortColumn(String sortColumn) {
//        if (StringUtils.isBlank(sortColumn)) {
//            this.sortColumn = null;
//        } else {
//            this.sortColumn = StringUtils.upperCharToUnderLine(sortColumn);
//        }
//    }

    /**
     * 获取index
     *
     * @return
     */
    public Integer getIndex() {
        return (currentPage - 1) * pageSize;
    }

    /**
     * 设置总条数的时候计算总页数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    /**
     * 设置排序方式
     */
    public void setSortMethod(String sortMethod) {
        if (StringUtils.isBlank(sortMethod)) {
            this.sortMethod = SORT_ASC;
        }
        if (sortMethod.toLowerCase().startsWith(SORT_ASC)) {
            this.sortMethod = SORT_ASC;
        } else if (sortMethod.toLowerCase().startsWith(SORT_DESC)) {
            this.sortMethod = SORT_DESC;
        } else {
            this.sortMethod = SORT_ASC;
        }
    }

}
