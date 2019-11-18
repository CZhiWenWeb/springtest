package com.czw.ms.server.system.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czw.ms.common.entity.RouterMeta;
import com.czw.ms.common.entity.VueRouter;
import com.czw.ms.common.entity.system.Menu;
import com.czw.ms.common.utils.TreeUtil;
import com.czw.ms.server.system.mapper.MenuMapper;
import com.czw.ms.server.system.server.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: czw
 * @CreateTime: 2019-11-13 11:31
 * @UpdeteTime: 2019-11-13 11:31
 * @Description:
 */
@Slf4j
@Service("menuService")
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	@Override
	public Set<String> findUserPermissions(String username) {
		List<Menu> userPermissions=this.baseMapper.findUserPermissions(username);
		return userPermissions.stream().map(Menu::getPerms).collect(Collectors.toSet());
	}

	@Override
	public List<VueRouter<Menu>> getUserRouters(String username) {
		List<Menu> menus=this.baseMapper.findUserMenus(username);
		List<VueRouter<Menu>> routes=new ArrayList<>();
		menus.forEach(menu->{
			VueRouter<Menu> route=new VueRouter<>();
			route.setId(menu.getMenuId().toString());
			route.setId(menu.getMenuId().toString());
			route.setParentId(menu.getParentId().toString());
			route.setPath(menu.getPath());
			route.setComponent(menu.getComponent());
			route.setName(menu.getMenuName());
			route.setMeta(new RouterMeta(menu.getMenuName(), menu.getIcon()));
			routes.add(route);
		});
		return TreeUtil.buildVueRouter(routes);
	}
}
