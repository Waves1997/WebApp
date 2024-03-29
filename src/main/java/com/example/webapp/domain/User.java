package com.example.webapp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.webapp.domain.po.UserInfo;
import com.example.webapp.enums.UserStatus;
import lombok.Data;

/**
 * 用户表
 *
 * @TableName t_user
 */
@TableName(value = "t_user", autoResultMap = true)
@Data
public class User implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 详细信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private UserInfo info;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private UserStatus status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}