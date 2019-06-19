package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 15:27
 * @UpdeteTime: 2019-06-18 15:27
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = {"spittr"},
excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class RootConfig {
}
