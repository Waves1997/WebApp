package com.example.webapp.service;

import com.example.webapp.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.webapp.domain.query.UserAgeRangeQuery;
import com.example.webapp.domain.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 13505
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2023-09-23 17:33:36
*/
public interface UserService extends IService<User> {

    List<User> getUsers(UserAgeRangeQuery query);

    UserVO getUserById(Long id);
}
