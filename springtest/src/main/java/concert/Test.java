package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 11:38
 * @UpdeteTime: 2019-06-18 11:38
 * @Description:
 */
public class Test {

		public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("config/spring.xml");
			Performance p= (Performance) context.getBean("performanceTest");
			p.perform();
		}
}
