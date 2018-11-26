package com.cjc.framework.core.request;

import lombok.Data;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 16:34
 * @Description:
 */
@Data
public class PageRequest {
    /**
     * 当前页面
     */
    private Integer page = 1;
    /**
     * 页大小
     */
    private Integer size = 10;
}
