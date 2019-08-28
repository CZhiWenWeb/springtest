package com.xyx.shiro.config.shiro;

import com.xyx.shiro.config.shiro.cache.CustomCacheManager;
import com.xyx.shiro.config.shiro.jwt.JwtFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-08-27 10:11
 * @UpdeteTime: 2019-08-27 10:11
 * @Description:shiro配置
 */
@Configuration
public class ShiroConfig {
	/**
	 * 配置使用自定义Realm，关闭shiro自带的session
	 *
	 * @param userRealm
	 * @return
	 */
	@Bean("securityManager")
	public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		//	使用自定义Realm
		defaultWebSecurityManager.setRealm(userRealm);
		//	关闭Shiro自带的session
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		//	设置自定义Cache缓存
		defaultWebSecurityManager.setCacheManager(new CustomCacheManager());
		return defaultWebSecurityManager;
	}

	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		//	添加自己的过滤器取名为jwt
		Map<String, Filter> filterMap = new HashMap<>();
		filterMap.put("jwt", new JwtFilter());
		factoryBean.setFilters(filterMap);
		factoryBean.setSecurityManager(securityManager);
		//	自定义url规则使用LinkedHashMap有序Map
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/**", "jwt");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
}
