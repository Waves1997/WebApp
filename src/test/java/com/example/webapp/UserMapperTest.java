package com.example.webapp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.webapp.domain.User;
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

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Tom");
        user.setGender("male");
        user.setAge(21);
        user.setEmail("tom@icloud.com");
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
        updateWrapper.lambda().eq(User::getId,1).set(User::getAge,23);
        userService.update(updateWrapper);
    }
}
