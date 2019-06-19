package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 17:09
 * @UpdeteTime: 2019-06-14 17:09
 * @Description:
 */
public class KinghtMain {
	public static void main(String[] args) {
		/*xml配置
		* */
		//类路径加载
		//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config/knights.xml");
		//系统文件加载
		//FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext("F:\\myrepository\\springtest\\src\\main\\resources\\config\\knights.xml");
		//从java配置中加载应用上下文，这里没有架子spring应用所需的xml文件，通过一个配置类加载bean
		//该context不需要.close();
		ApplicationContext context=new AnnotationConfigApplicationContext(com.springinaction.knights.config.KnightConfig.class);
		Knight knight=context.getBean(Knight.class);
		knight.embarkOnQuest();
		//context.close();
		/*
		注解
		*/
		//KnightConfig knightConfig=new KnightConfig();
		//knightConfig.knight().embarkOnQuest();
	}
}
