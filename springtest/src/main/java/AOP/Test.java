package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 10:08
 * @UpdeteTime: 2019-06-18 10:08
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config/aop.xml");
		HelloWorld h1= (HelloWorld) context.getBean("helloWorldImpl1");
		h1.doPrint();

	}

}
