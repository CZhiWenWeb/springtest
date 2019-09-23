package com.czw.browser.data.mapper;

import com.czw.browser.data.model.entity.Permission;
import com.czw.browser.data.util.MyMapper;

import java.util.List;

public interface PermissionMapper extends MyMapper<Permission> {
	List<String> selectPermissionByUserId(Integer id);
}