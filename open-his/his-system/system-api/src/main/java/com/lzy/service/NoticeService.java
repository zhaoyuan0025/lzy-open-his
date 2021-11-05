package com.lzy.service;

import com.lzy.domain.Notice;
import com.lzy.dto.NoticeDTO;
import com.lzy.page.Page;

/**
 * @program: open-his
 * @description: 系统公告
 * @author: lzy
 * @create: 2021-05-12 15:34
 **/
public interface NoticeService {

    /**
     *分页查询
     * @param page
     * @return
     */
    Page<NoticeDTO> page(Page<NoticeDTO> page);

    /**
     * 添加
     * @param dto
     * @return
     */
    Boolean save(NoticeDTO dto);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 修改
     * @param dto
     * @return
     */
    Integer update(NoticeDTO dto);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Notice getById(Long id);
}
