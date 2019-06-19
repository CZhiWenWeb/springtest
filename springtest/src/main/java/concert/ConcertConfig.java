package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 11:04
 * @UpdeteTime: 2019-06-17 11:04
 * @Description:
 */
@Configuration
//启用AspectJ自动代理
@EnableAspectJAutoProxy
//启用组件扫描（默认当前包下）
@ComponentScan
public class ConcertConfig {
	@Bean
	//声明Audience bean
	public Audience audience(){
		return new Audience();
	}
}
