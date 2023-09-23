package com.example.webapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webapp.domain.User;
import com.example.webapp.service.UserService;
import com.example.webapp.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 13505
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-09-23 17:33:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




