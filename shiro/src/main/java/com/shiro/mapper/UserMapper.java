package com.shiro.mapper;

import com.shiro.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}