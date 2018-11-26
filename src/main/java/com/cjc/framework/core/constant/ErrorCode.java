package com.cjc.framework.core.constant;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 16:28
 * @Description: 程序错误码 都在这里
 */
public class ErrorCode {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("errorcode");

    /**
     * 系统登录有关
     */
    public static class System {
        // 参数有误
        public static Integer ERROR_CODE_1000 = 1000;
    }


    /**
     * 根据错误码返回错误信息 错误码在errordoe.preperties中，错误码code不包含前缀erroe_code_。
     * 如：errordoe中的error_code_11001，在调用该方法直接传11001即可。
     *
     * @param code 错误码
     * @return String
     */
    public static String getMsg(int code) {
        try {
            return new String(RESOURCE_BUNDLE.getString("error_code_" + code).getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
