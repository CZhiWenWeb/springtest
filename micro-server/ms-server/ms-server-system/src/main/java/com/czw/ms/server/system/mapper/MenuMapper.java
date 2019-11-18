package com.czw.ms.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czw.ms.common.entity.system.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
	/**
	 * 通过用户名查询权限
	 * @param username username
	 * @return 权限信息
	 */
	List<Menu> findUserPermissions(String username);

	/**
	 * 通过用户名查询菜单信息
	 * @param username
	 * @return
	 */
	List<Menu> findUserMenus(String username);
}
