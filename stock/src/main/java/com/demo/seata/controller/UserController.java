package com.demo.seata.controller;

import com.demo.seata.dao.User;
import com.demo.seata.dao.UserRepository;
import com.demo.seata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public String addUser(int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setPassword("password" + i);
            user.setAge(new Random().nextInt(100));
            result += userService.addUser(user);
        }
        return result == count ? "success" : "failure";
    }

    @GetMapping("/user")
    public List<User> getUser() {
        List<User> userList = userRepository.findAllByOrderById();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        return userList;
    }
}
