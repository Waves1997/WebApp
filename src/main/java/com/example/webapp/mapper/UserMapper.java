package com.example.webapp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.webapp.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 13505
 * @description 针对表【t_user(用户表)】的数据库操作Mapper
 * @createDate 2023-09-23 17:33:36
 * @Entity com.example.webapp.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    void updateAge(@Param(Constants.WRAPPER) Wrapper<User> wrapper, @Param("inc") Integer inc);
}




