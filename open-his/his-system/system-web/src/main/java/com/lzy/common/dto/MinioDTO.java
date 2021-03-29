package com.lzy.common.dto;

import com.lzy.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 文件上传
 * @author: lzy
 * @create: 2021-03-05 10:21
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MinioDTO extends BaseDto implements Serializable {

    @ApiModelProperty(value = "文件")
    private MultipartFile file;

    @ApiModelProperty(value = "minio_bucket名字")
    private String type;

}
