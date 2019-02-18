package com.example.demo.api.model;

import java.io.Serializable;

/**
 * 路径：com.example.demo.api.model
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/6/12 15:55
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class User implements Serializable {
    private Integer id;
    private String user_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
