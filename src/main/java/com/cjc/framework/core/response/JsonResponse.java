package com.cjc.framework.core.response;

import com.cjc.framework.core.constant.Const;
import com.cjc.framework.core.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 16:34
 * @Description: 返回  成功 code为0
 */
public class JsonResponse {
    private static <T> ResponseEntity<Object> response(T data, String message, int code) {
        JsonData<T> jd = new JsonData();
        jd.setData(data);
        jd.setCode(code);
        jd.setMessage(message);
        return new ResponseEntity<>(jd, HttpStatus.OK);
    }

    /**
     * 成功
     *
     * @param data
     * @param message
     * @return
     */
    public static <T> ResponseEntity<Object> success(T data, String message) {
        return response(data, message, Const.DictValue.RESULT_OK);
    }

    /**
     * 成功 message默认OK
     *
     * @param data
     * @return
     */
    public static <T> ResponseEntity<Object> success(T data) {
        return response(data, Const.DictValue.RESULT_CG, Const.DictValue.RESULT_OK);
    }

    /**
     * 成功 没有传参
     *
     * @return
     */
    public static ResponseEntity<Object> success() {
        return response(null, Const.DictValue.RESULT_CG, Const.DictValue.RESULT_OK);
    }

    /**
     * 失败
     *
     * @param code 错误码
     * @return
     */
    public static ResponseEntity<Object> fail(int code) {
        return response(null, ErrorCode.getMsg(code), code);
    }

    /**
     * 失败 带 data
     *
     * @param code 错误码
     * @return
     */
    public static ResponseEntity<Object> fail(int code, Object data) {
        return response(data, ErrorCode.getMsg(code), 0);
    }
}
