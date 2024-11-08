package com.bhui.rocketmqdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bhui.rocketmqdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
