package com.xyx.shiro.mapper;

import com.xyx.shiro.model.PermissionDto;
import com.xyx.shiro.model.RoleDto;
import com.xyx.shiro.model.entity.Permission;
import com.xyx.shiro.util.MyMapper;

import java.util.List;

public interface PermissionMapper extends MyMapper<PermissionDto> {
	/**
	 * 根据role查询permission
	 * @param roleDto
	 * @return
	 */
	List<PermissionDto> findPermissionByRole(RoleDto roleDto);
}