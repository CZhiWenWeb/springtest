package com.xyx.security.browser.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyx.security.core.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的退出成功处理器,如果设置了imooc.security.browser.signOutUrl,则跳到配置的地址上,
 * 如果没配置,则返回json格式的响应
 * @author TiHom
 */
public class TiHomLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    public TiHomLogoutSuccessHandler(String signOutUrl){
        this.signOutUrl = signOutUrl;
    }

    private String signOutUrl;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");

        if(StringUtils.isBlank(signOutUrl)){
            //如果是空的将json字符串返回
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            //如果不是空的直接跳转
            httpServletResponse.sendRedirect(signOutUrl);
        }

    }
}
