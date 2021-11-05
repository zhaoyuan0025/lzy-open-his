package com.lzy.service.impl;

import com.lzy.domain.Notice;
import com.lzy.dto.NoticeDTO;
import com.lzy.exception.MedicalException;
import com.lzy.mapper.NoticeMapper;
import com.lzy.page.Page;
import com.lzy.service.NoticeService;
import com.lzy.utils.MiuKit;
import com.lzy.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: open-his
 * @description: 系统公告实现类
 * @author: lzy
 * @create: 2021-05-12 15:34
 **/
@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {


    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<NoticeDTO> page(Page<NoticeDTO> page) {

        //查询所有数据
        List<NoticeDTO> dtoList = noticeMapper.getByPage(page);
        page.setList(dtoList);

        //查询所有的总数据条数
        Integer count = noticeMapper.getCount(page);
        page.setTotalCount(count);

        return page;
    }

    /**
     * 添加
     * @param dto
     * @return
     */
    @Override
    public Boolean save(NoticeDTO dto) {
        Notice notice = Notice.builder()
                .createTime(new Date())
                .createBy(ServletUtils.getRequest().getHeader("username"))
                .deleted(0)
                .noticeContent(dto.getNoticeContent())
                .noticeType(dto.getNoticeType())
                .remark(dto.getRemark())
                .status(dto.getStatus())
                .noticeTitle(dto.getNoticeTitle())
                .build();
        Integer insert = noticeMapper.insert(notice);
        if (insert.compareTo(1)==0){
            return true;
        }
        return false;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Boolean delete(Long id) {
        Notice notice = noticeMapper.selectById(id);
        notice.setDeleted(1);
        Integer i = noticeMapper.updateById(notice);
        if (i.compareTo(1)==0){
            return true;
        }
        return false;
    }

    /**
     * 修改
     * @param dto
     * @return
     */
    @Override
    public Integer update(NoticeDTO dto) {
        Notice notice = Notice.builder()
                .id(dto.getId())
                .noticeTitle(dto.getNoticeTitle())
                .noticeContent(dto.getNoticeContent())
                .noticeType(dto.getNoticeType())
                .updateTime(new Date())
                .status(dto.getStatus())
                .build();
        int byId = noticeMapper.updateById(notice);
        return byId;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Notice getById(Long id) {
        Notice notice = noticeMapper.selectById(id);
        if (MiuKit.isEmpty(notice)) {
            throw new MedicalException("公告信息错误，请联系管理员！");
        }
        return notice;
    }
}
