package AOP;

import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 16:35
 * @UpdeteTime: 2019-06-17 16:35
 * @Description:
 */
public class HelloWorldImpl2 implements HelloWorld
{
	public void printHelloWorld()
	{
		System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
	}

	public void doPrint()
	{
		System.out.println("Enter HelloWorldImpl2.doPrint()");
		return ;
	}
}
