package com.security.utils;

import cn.hutool.core.bean.BeanUtil;
import com.security.config.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security上下文工具类
 */
public class SecurityUtils {

    /**
     * 获取上下文中的Authentication对象
     * @return Authentication对象
     */
    public static Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 从上下文中获取当前用户对象
     * @return 用户对象，如果上下文中没有填充用户信息则返回Null
     */
    public static UserDetailsImpl getUser(){
        Object principal = getAuthentication().getPrincipal();
        return BeanUtil.isNotEmpty(principal) && principal instanceof UserDetailsImpl ? (UserDetailsImpl)principal : null;
    }
}
