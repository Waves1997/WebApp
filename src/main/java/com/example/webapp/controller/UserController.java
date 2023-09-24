package com.example.webapp.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.webapp.domain.User;
import com.example.webapp.domain.dto.UserDTO;
import com.example.webapp.domain.query.UserAgeRangeQuery;
import com.example.webapp.domain.vo.UserVO;
import com.example.webapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
public class UserController {
    private final UserService userService;

    @Operation(summary = "新增用户")
    @PostMapping("/saveUser")
    public Boolean saveUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userService.save(user);
    }

    @Operation(summary = "查找用户")
    @GetMapping("/getUserById")
    public UserVO getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "更新用户邮箱")
    @PutMapping("/changeEmail/{id}/new/{newEmail}")
    public Boolean changeEmail(@PathVariable Long id, @PathVariable String newEmail) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getId, id).set(User::getEmail, newEmail);
        return userService.update(wrapper);
    }

    @Operation(summary = "查找年龄范围内的用户")
    @GetMapping("/getUsers")
    public List<User> getUsers(UserAgeRangeQuery query) {
        return userService.getUsers(query);
    }
}
