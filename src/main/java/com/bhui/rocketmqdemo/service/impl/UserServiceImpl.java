package com.bhui.rocketmqdemo.service.impl;

import com.bhui.rocketmqdemo.entity.User;
import com.bhui.rocketmqdemo.mapper.UserMapper;
import com.bhui.rocketmqdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper  userMapper;
    @Override
    public void addPoints(Long userId, int points) {
            User user = userMapper.selectById(userId);
            if(user != null){
                user.setPoints(user.getPoints()+points);
                userMapper.updateById(user);
            }
    }
}
