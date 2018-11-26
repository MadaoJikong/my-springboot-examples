package com.cjc.framework.core.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 18:51
 * @Description:
 */
@Data
public class User {
    private Long id;
    private String uuid;
    private String name;
    private Integer status;
    private Boolean isDelete;
    private Long creator;
    private Date created;
    private Date updated;
}
