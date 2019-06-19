package AOP;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 16:35
 * @UpdeteTime: 2019-06-17 16:35
 * @Description:
 */
public class HelloWorldImpl1 implements HelloWorld{
	@Override
	public void printHelloWorld() {
		System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
	}

	@Override
	public void doPrint() {
		System.out.println("Enter HelloWorldImpl1.doPrint()");
		return ;
	}
}
