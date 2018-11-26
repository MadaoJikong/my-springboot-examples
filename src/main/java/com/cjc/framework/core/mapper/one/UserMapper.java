package com.cjc.framework.core.mapper.one;

import com.cjc.framework.core.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 18:51
 * @Description:
 */
@Repository
public interface UserMapper {
    @Select("select id,uuid,name,status,is_delete as isDelete,creator,created,updated from user_one where id=#{id}")
    User findOne(@Param("id") int id);
}
