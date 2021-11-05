package com.lzy.controller.system;

import com.lzy.domain.Notice;
import com.lzy.dto.NoticeDTO;
import com.lzy.page.Page;
import com.lzy.service.NoticeService;
import com.lzy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: open-his
 * @description: 系统公告的接口
 * @author: lzy
 * @create: 2021-05-12 15:32
 **/
@RestController
@RequestMapping("/system")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 分页查询
     * @param page
     * @return
     */
    @PostMapping("/page")
    public Result<Page<NoticeDTO>> page(@RequestBody Page<NoticeDTO> page){
        Page<NoticeDTO> dtoPage = noticeService.page(page);
        return new Result<>("查询成功！",dtoPage);
    }

    /**
     * 添加
     * @param dto
     * @return
     */
    @PostMapping("/notice")
    public Result<Boolean> save(@RequestBody NoticeDTO dto){
        Boolean b = noticeService.save(dto);
        return new Result<>("添加成功！",b);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id){
        Boolean b = noticeService.delete(id);
        return new Result<>("删除成功！",b);
    }

    /**
     * 修改
     * @param dto
     * @return
     */
    @PutMapping("/notice")
    public Result<Integer> update(@RequestBody NoticeDTO dto){
        Integer b = noticeService.update(dto);
        return new Result<>("修改成功！",b);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Result<Notice> getById(@PathVariable Long id){
        Notice notice = noticeService.getById(id);
        return new Result<>(notice);
    }

}
