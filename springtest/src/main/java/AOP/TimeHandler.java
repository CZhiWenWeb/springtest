package AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 16:36
 * @UpdeteTime: 2019-06-17 16:36
 * @Description:
 */
public class TimeHandler
{
	public void helloWorld(){}
	public void printTime()
	{
		System.out.println("CurrentTime = " + System.currentTimeMillis());
	}

}