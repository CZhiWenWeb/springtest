package com.example.demo.service.impl;

import com.example.demo.mapper.PermissionMapper;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 11:39
 * @UpdeteTime: 2019-09-07 11:39
 * @Description:
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	PermissionMapper mapper;
	@Override
	public List<String> selectPermissionByUserId(Integer id) {
		return mapper.selectPermissionByUserId(id);
	}
}
