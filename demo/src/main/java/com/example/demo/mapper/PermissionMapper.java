package com.example.demo.mapper;

import com.example.demo.model.entity.Permission;
import com.example.demo.util.MyMapper;

import java.util.List;

public interface PermissionMapper extends MyMapper<Permission> {
	List<String> selectPermissionByUserId(Integer id);
}