package com.moon.immncweb.common.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(0, "操作成功."),
    SIGN_IN_OK(2,"登录成功"),
    LOGOUT_OK(3,"注销登录成功"),
    SIGN_IN_INPUT_FAIL(-4,"账号或密码错误"),
    SIGN_IN_FAIL(-3,"登录失败"),
    FAIL(-1,"操作失败"),
    LOGOUT_FAIL(-2,"注销登录失败"),
    SING_IN_INPUT_EMPTY(-5,"账户和密码均不能为空"),
    NOT_SING_IN(-6,"用户未登录或身份异常");

    public Integer code;
    public String msg;
}
