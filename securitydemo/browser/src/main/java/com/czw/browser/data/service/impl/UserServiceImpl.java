package com.czw.browser.data.service.impl;

import com.czw.browser.data.mapper.PermissionMapper;
import com.czw.browser.data.model.entity.User;
import com.czw.browser.data.service.UserService;
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
