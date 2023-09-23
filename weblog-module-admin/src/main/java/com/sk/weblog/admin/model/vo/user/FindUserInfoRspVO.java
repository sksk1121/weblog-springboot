package com.sk.weblog.admin.model.vo.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindUserInfoRspVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
}
