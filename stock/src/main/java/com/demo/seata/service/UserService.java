package com.demo.seata.service;

import com.demo.seata.dao.User;
import com.demo.seata.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public int addUser(User user) {
        user.setCreateBy("admin");
        user.setUpdateBy("admin");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userRepository.save(user);
        return 1;
    }
}
