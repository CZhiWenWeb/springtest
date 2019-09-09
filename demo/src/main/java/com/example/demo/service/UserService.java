package com.example.demo.service;

import com.example.demo.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 11:38
 * @UpdeteTime: 2019-09-07 11:38
 * @Description:
 */
@Service
public interface UserService extends BaseService<User>{
	/**
	 * 获取权限
	 */
	List<String> selectPermissionByUserId(Integer id);
}
