package com.lzy.common.oss;

import java.io.InputStream;

/**
 * @program: open-his
 * @description: oss文件上传的实现类
 * @author: lzy
 * @create: 2021-12-22 10:55
 **/
public interface OssService {

    /**
     * oss 文件上传
     * @param inputStream
     * @param module
     * @param originalFilename
     * @return string
     */
    String upload(InputStream inputStream, String module, String originalFilename);
}
