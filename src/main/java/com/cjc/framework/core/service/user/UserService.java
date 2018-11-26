package com.cjc.framework.core.service.user;

import com.cjc.framework.core.entity.User;
import com.cjc.framework.core.mapper.one.UserMapper;
import com.cjc.framework.core.mapper.two.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/26 09:51
 * @Description: 用户服务层
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User1Mapper user1Mapper;

    /**
     * @param id
     * @return
     */
    public User getUser(int id) {
        User user = userMapper.findOne(id);
        return user;
    }

    public User getUser1(int id) {
        User user = user1Mapper.findOne(id);
        return user;
    }
}
