package com.czw.ms.server.system.controller;

import com.czw.ms.common.entity.MsResponse;
import com.czw.ms.common.entity.VueRouter;
import com.czw.ms.common.entity.system.Menu;
import com.czw.ms.server.system.server.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: czw
 * @CreateTime: 2019-11-13 14:39
 * @UpdeteTime: 2019-11-13 14:39
 * @Description:
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private IMenuService menuService;

	@GetMapping("/{username}")
	public MsResponse getUserRouters(@NotBlank(message = "{required}") @PathVariable String username){
		Map<String,Object> result=new HashMap<>();
		//构建用户路由对象
		List<VueRouter<Menu>> userRouters=this.menuService.getUserRouters(username);
		//获取用户权限信息
		Set<String> userPermissions=this.menuService.findUserPermissions(username);

		result.put("routes",userRouters);
		result.put("permissions",userPermissions);
		return new MsResponse().data(result);
	}

}
