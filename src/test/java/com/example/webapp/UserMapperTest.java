package com.example.webapp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.webapp.domain.User;
import com.example.webapp.domain.po.UserInfo;
import com.example.webapp.mapper.UserMapper;
import com.example.webapp.service.UserService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Jackson");
        user.setInfo(UserInfo.of("135xxxxxxxx", "青年", "male"));
        user.setAge(29);
        user.setEmail("jackson@icloud.com");
        userService.save(user);
    }

    @Test
    public void testSelect() {
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectBatch() {
        List<User> users = userService.listByIds(List.of(1, 2));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectAll() {
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(User::getId, 1).set(User::getAge, 23);
        userService.update(updateWrapper);
    }

    @Test
    public void testCustomUpdate() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getName, "Tom");
        userMapper.updateAge(wrapper, 10);
    }
}
