package com.example.webapp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.example.webapp.domain.Address;
import com.example.webapp.domain.User;
import com.example.webapp.domain.query.UserAgeRangeQuery;
import com.example.webapp.domain.vo.AddressVO;
import com.example.webapp.domain.vo.UserVO;
import com.example.webapp.enums.UserStatus;
import com.example.webapp.mapper.UserMapper;
import com.example.webapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 13505
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-09-23 17:33:36
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getUsers(UserAgeRangeQuery query) {
        return lambdaQuery().between(Objects.nonNull(query.getMaxAge()) && Objects.nonNull(query.getMinAge()), User::getAge, query.getMinAge(), query.getMaxAge()).list();
    }

    @Override
    public UserVO getUserById(Long id) {
        User user = getById(id);
        if (Objects.isNull(user) || user.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常");
        }
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        List<Address> addresses = Db.lambdaQuery(Address.class).eq(Address::getUserId, id).list();
        userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        return userVO;
    }
}




