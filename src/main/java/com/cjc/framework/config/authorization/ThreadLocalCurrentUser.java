package com.cjc.framework.config.authorization;

/**
 * @Author: chengjunchao
 * @Date: 2018/11/23 15:43
 * @Description: ThreadLocal对象
 */
public class ThreadLocalCurrentUser {
    private static ThreadLocal<CurrentUser> currentUser = new ThreadLocal<CurrentUser>();

    public static CurrentUser getCurrentUser() {
        return currentUser.get();
    }

    /**
     * 设置当前登录用户信息
     *
     * @param user
     */
    public static void setCurrentUser(CurrentUser user) {
        currentUser.set(user);
    }

    /**
     * 功能描述:移除当前
     *
     * @param
     * @return: void
     * @author: chengjunchao
     * @date: 2018/6/21 9:25
     */
    public static void currentUserRemove() {
        currentUser.remove();
    }
}
