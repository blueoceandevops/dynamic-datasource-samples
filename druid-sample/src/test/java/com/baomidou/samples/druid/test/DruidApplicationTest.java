package com.baomidou.samples.druid.test;

import com.baomidou.samples.druid.DruidApplication;
import com.baomidou.samples.druid.entity.User;
import com.baomidou.samples.druid.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DruidApplication.class)
public class DruidApplicationTest {

    private final Random random = new Random();

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("测试用户" + random.nextInt());
        user.setAge(random.nextInt(100));
        userService.addUser(user);
    }

    @Test
    public void selectUsersFromDs() {
        userService.selectMasterUsers();
    }

    @Test
    public void selectUserFromDsGroup() {
        userService.selectSlaveUsers();
    }

}