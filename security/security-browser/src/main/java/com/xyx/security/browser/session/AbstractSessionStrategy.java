package com.xyx.security.browser.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

/**
 * 抽象的session失效处理器
 */
@Slf4j
public class AbstractSessionStrategy {
    //    跳转的url
    private String destinationUrl;
    //    重定向策略
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    //    跳转前是否创建新的session
    private boolean createNewSession = true;
    private ObjectMapper objectMapper = new ObjectMapper();

}
