package com.lzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.domain.Notice;
import com.lzy.dto.NoticeDTO;
import com.lzy.page.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: open-his
 * @description: 通知公告
 * @author: lzy
 * @create: 2021-05-13 10:49
 **/
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<NoticeDTO> getByPage(Page<NoticeDTO> page);

    /**
     * 查询总的数据条数
     * @param page
     * @return
     */
    Integer getCount(Page<NoticeDTO> page);
}
