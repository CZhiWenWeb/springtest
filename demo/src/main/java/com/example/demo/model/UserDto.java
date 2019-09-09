package com.example.demo.model;

import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-09-07 11:35
 * @UpdeteTime: 2019-09-07 11:35
 * @Description:自定义UserDetails实现类
 */

public class UserDto implements UserDetails {
	private UserService userService;
	private User user;
	@Autowired
	public UserDto(User user,UserService userService){
		this.user=user;
		this.userService=userService;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> authList=userService.selectPermissionByUserId(user.getId());
		ArrayList<GrantedAuthority> authorities=new ArrayList<>();
		authList.stream().forEach
				//遍历authList，使用匿名内部类新建grantedAuthority的实例,并添加到list
				((author)-> authorities.add(()->author));
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
