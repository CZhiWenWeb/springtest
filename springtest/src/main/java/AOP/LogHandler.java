package AOP;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 14:26
 * @UpdeteTime: 2019-06-18 14:26
 * @Description:
 */
public class LogHandler {
	public void LogBefore(){
		System.out.println("Log before method");
	}
	public void LogAfter(){
		System.out.println("Log after method");
	}
}
