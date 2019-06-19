package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 15:14
 * @UpdeteTime: 2019-06-18 15:14
 * @Description:
 */
@Configuration
@EnableWebMvc//启用SpringMVC
@ComponentScan("spittr.web")//启用组件扫描
public class WebConfig
extends WebMvcConfigurationSupport {
	/**
	 * 配置jsp试图解析器
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver=
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

	/**
	 * 配置静态资源的处理
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer
	){
		configurer.enable();
	}
}
