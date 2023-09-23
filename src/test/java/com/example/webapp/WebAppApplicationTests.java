package com.example.webapp;

import com.example.webapp.domain.User;
import com.example.webapp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.List;

@SpringBootTest
class WebAppApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
