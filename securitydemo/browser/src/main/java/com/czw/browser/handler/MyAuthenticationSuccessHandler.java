package com.czw.browser.handler;

import com.czw.code.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 11:42
 * @UpdeteTime: 2019-09-23 11:42
 * @Description:
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private SecurityProperties securityProperties;

}
