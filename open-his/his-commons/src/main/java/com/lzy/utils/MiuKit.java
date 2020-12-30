//MiuKit.java
//Created by lzh on 2018/5/21.
//Copyright  2017年 sythealth. All rights reserved.
package com.lzy.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.*;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.poi.excel.ExcelUtil;
import com.sun.imageio.plugins.common.ImageUtil;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.ThreadUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.crypto.SecretKey;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: lzh
 * @description:
 * @since:
 * @version:
 * @date: Created in 2018/5/21.
 */
public class MiuKit {
    private MiuKit() {
    }


    /***
     * 判断传入的对象是否为空
     *
     * @param obj
     *            待检查的对象
     * @return 返回的布尔值, 为空或等于0时返回true
     */
    public static boolean isEmpty(java.lang.Object obj) {
        return checkObjectIsEmpty(obj, true);
    }

    public static boolean hasEmpty(java.lang.Object... objs) {
        if (isEmpty(objs)) {
            return true;
        }
        for (java.lang.Object obj : objs) {
            if (isEmpty(obj)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 判断传入的对象是否不为空
     *
     * @param obj
     *            待检查的对象
     * @return 返回的布尔值, 不为空或不等于0时返回true
     */
    public static boolean isNotEmpty(java.lang.Object obj) {
        return checkObjectIsEmpty(obj, false);
    }


    @SuppressWarnings("rawtypes")
    private static boolean checkObjectIsEmpty(java.lang.Object obj, boolean bool) {
        if (null == obj) {
            return bool;
        } else if (obj == "" || "".equals(obj)) {
            return bool;
        } else if (obj instanceof Integer || obj instanceof Long
                || obj instanceof Double) {
            try {
                Double.parseDouble(obj + "");
            } catch (Exception e) {
                return bool;
            }
        } else if (obj instanceof java.lang.String) {
            if (((java.lang.String) obj).length() <= 0) {
                return bool;
            }
            if ("null".equalsIgnoreCase(obj + "")) {
                return bool;
            }
        } else if (obj instanceof Map) {
            if (((Map) obj).size() == 0) {
                return bool;
            }
        } else if (obj instanceof java.util.Collection) {
            if (((java.util.Collection) obj).size() == 0) {
                return bool;
            }
        } else if (obj instanceof java.lang.Object[]) {
            if (((java.lang.Object[]) obj).length == 0) {
                return bool;
            }
        }
        return !bool;
    }

    private static final java.lang.String CREATE_ID_FIELD = "createBy";
    private static final java.lang.String UPDATE_ID_FIELD = "updateBy";
    private static final java.lang.String CREATE_TIME_FIELD = "createTime";
    private static final java.lang.String UPDATE_TIME_FIELD = "updateTime";
    private static final java.lang.String DR_FIELD = "dr";
    private static final java.lang.String VERSION_FIELD = "version";


    private final static java.lang.String DEFAULT_PIC_HOST = "http://file.zhmiu.com";

    public static java.lang.String getPicUrl(java.lang.String picUri) {
        return getPicUrl(picUri, DEFAULT_PIC_HOST);
    }

    public static java.lang.String getPicUrl(java.lang.String picUri, java.lang.String host) {
        if (isEmpty(picUri) || isEmpty(host)) {
            return picUri;
        }
        if (picUri.startsWith("/")) {
            return host + picUri;
        }
        return picUri;
    }

    public static java.lang.String removePicHost(java.lang.String picUrl) {
        return removePicHost(picUrl, DEFAULT_PIC_HOST);
    }

    public static java.lang.String removePicHost(java.lang.String picUrl, java.lang.String host) {
        if (isEmpty(picUrl) || isEmpty(host)) {
            return picUrl;
        }
        return picUrl.replace(picUrl, host);
    }

    /**
     * 获取订单号
     *
     * @param date 日期
     * @return 订单号
     */
    public static synchronized java.lang.String getOrderNum(int appId, java.util.Date date, java.lang.String channel) {
        java.lang.String time = DateUtil.formatDate(date);
        long randomNum = System.currentTimeMillis();
        if (MiuKit.isEmpty(channel)) {
            channel = "1";
        }
        return appId + "-" + time + "-" + channel + "-" + (randomNum + "").substring(9) + getRandomNum(100000, 999999);
    }

    /**
     * 获取随机数--最大值比结束随机数少1
     *
     * @param startNum 开始随机数
     * @param endNum   结束随机数
     * @return 随机数
     */
    public static int getRandomNum(int startNum, int endNum) {
        return (int) (Math.random() * (endNum - startNum) + startNum);
    }

    /**
     * Http请求工具类
     */
    public static class Http extends HttpUtils {

    }


    /**
     * Excel工具类
     */
    public static class Excel extends ExcelUtil {

    }

    /**
     * 随机工具类
     *
     * @author Looly
     */
    public static class Random extends RandomUtils {

    }

    /**
     * Hash算法大全<br> 推荐使用FNV1算法
     */
    public static class Hash extends HashUtil {

    }


    /**
     * 文件工具类
     */
    public static class File extends FileUtil {

    }


    /**
     * 正则相关工具类
     */
    public static class Regex extends ReUtil {

    }

    /**
     * 线程池工具
     */
    public static class Thread extends ThreadUtils {

    }

    /**
     * 类工具类
     */
    public static class Class extends ClassUtil {

    }

    /**
     * 压缩工具类
     */
    public static class Zip extends ZipUtil {

    }


    /**
     * 网络相关工具
     */
    public static class Net extends NetUtil {

    }

    /**
     * 字符集工具类
     */
    public static class Charset extends CharsetUtil {

    }

    /**
     * Bean工具类
     */
    public static class Bean extends BeanUtil {

    }

    /**
     * 日期工具类入口
     */
    public static class Date extends DateUtils {

    }


    /**
     * 针对 {@link java.lang.reflect.Type} 的工具类封装<br>
     * 最主要功能包括：
     * <p>
     * <pre>
     * 1. 获取方法的参数和返回值类型（包括Type和Class）
     * 2. 获取泛型参数类型（包括对象的泛型参数或集合元素的泛型类型）
     * </pre>
     *
     * @author Looly
     * @since 3.0.8
     */
    public static class Type extends TypeUtil {

    }


    public static java.lang.String getEncryptStr(java.lang.String data) {
        AES aes = SecureUtil.aes(getSecretEncoded());
        return aes.encryptHex(data);
    }

    public static java.lang.String getMd5(java.lang.String target) {
        return DigestUtil.md5Hex(target);
    }

    public static java.lang.String getDecryptStr(java.lang.String data) {
        AES aes = SecureUtil.aes(getSecretEncoded());
        return aes.decryptStr(data);
    }

    private static byte[] getSecretEncoded() {
        SecretKey secretKey = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), "1b88ab6d1B88AB6D".getBytes());
        return secretKey.getEncoded();
    }

}
