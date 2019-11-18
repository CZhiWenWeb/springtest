package com.czw.ms.common.utils;

import com.czw.ms.common.entity.VueRouter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-11-13 14:20
 * @UpdeteTime: 2019-11-13 14:20
 * @Description:
 */
public class TreeUtil {
	private final static String TOP_NODE_ID="0";

	/**
	 * 构造前端路由
	 * @param routes
	 * @param <T>
	 * @return
	 */
	public static <T>List<VueRouter<T>> buildVueRouter(List<VueRouter<T>> routes){
		if (routes==null){
			return null;
		}

		List<VueRouter<T>> topRoutes=new ArrayList<>();
		VueRouter<T> router=new VueRouter<>();
		routes.forEach(route->{
			String parentId=route.getParentId();
			if (parentId==null||TOP_NODE_ID.equals(parentId)){
				topRoutes.add(route);
				return;
			}
			for (VueRouter<T> parent:routes){
				String id=parent.getId();
				if (id!=null&&id.equals(parentId)){
					if (parent.getChildren()==null)
						parent.initChildren();
					parent.getChildren().add(route);
					parent.setAlwaysShow(true);
					parent.setHasChildren(true);
					route.setHasParent(true);
					parent.setHasParent(true);
					return;
				}
			}
		});
		VueRouter<T> router404=new VueRouter<>();
		router404.setName("404");
		router404.setComponent("error-page/404");
		router404.setPath("*");

		topRoutes.add(router404);
		return topRoutes;
	}
}
