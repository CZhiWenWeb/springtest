package com.springinaction.knights;

import com.springinaction.knights.config.KnightConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config/knights.xml");
		Knight knight=context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
		/*
		注解
		*/
		//KnightConfig knightConfig=new KnightConfig();
		//knightConfig.knight().embarkOnQuest();
	}
}
