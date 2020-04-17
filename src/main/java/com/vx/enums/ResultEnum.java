package com.vx.enums;

import lombok.Getter;

/**
 * @author hobo
 * @description
 */
@Getter
public enum ResultEnum {
    /**
     *
     */

    USER_NOT_LOGIN(1,"用户登录信息过期"),

    AUTHENTICATION_ERROR(401, "用户认证失败,请重新登录"),
    PERMISSION_DENNY(403, "权限不足"),
    NOT_FOUND(404, "url错误,请求路径未找到"),
    SERVER_ERROR(500, "服务器未知错误:%s"),
    BIND_ERROR(511, "参数校验错误:%s"),
    REQUEST_METHOD_ERROR(550, "不支持%s的请求方式");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
