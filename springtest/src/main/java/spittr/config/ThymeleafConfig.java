package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @Author: czw
 * @CreateTime: 2019-06-21 16:04
 * @UpdeteTime: 2019-06-21 16:04
 * @Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class ThymeleafConfig extends
		WebMvcConfigurationSupport {
	/**
	 * Thymeleaf视图解析器
	 */
	//@Bean
	//public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
	//	ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
	//	viewResolver.setTemplateEngine(templateEngine);
	//}
}
