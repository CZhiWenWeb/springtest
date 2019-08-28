package com.xyx.shiro.mapper;

import com.xyx.shiro.model.RoleDto;
import com.xyx.shiro.model.UserDto;
import com.xyx.shiro.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<RoleDto> {
	List<RoleDto> findRoleByUser(UserDto userDto);
}