package com.example.webapp.mapper;

import com.example.webapp.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13505
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-09-23 17:33:36
* @Entity com.example.webapp.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




