package com.lzy.common.minio.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 上传的实体类
 * @author: lzy
 * @create: 2021-03-05 16:11
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UploadDTO implements Serializable {

    /**
     * 上传的文件
     */
    @ApiModelProperty(value = "文件")
    private MultipartFile file;

    /**
     * bucket的名称
     */
    @ApiModelProperty(value = "minio_bucket名字")
    private String buckName;
}
