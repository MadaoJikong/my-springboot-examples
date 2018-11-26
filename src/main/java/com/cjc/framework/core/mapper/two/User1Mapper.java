package com.cjc.framework.core.mapper.two;

import com.cjc.framework.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 18:51
 * @Description: 这个 虽然是两个包下的  但Mapper不能同名
 */
@Repository
public interface User1Mapper {
    @Select("select id,uuid,name,status,is_delete as isDelete,creator,created,updated from user_two where id=#{id}")
    User findOne(@Param("id") int id);
}
