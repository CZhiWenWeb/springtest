package concert;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 10:39
 * @UpdeteTime: 2019-06-17 10:39
 * @Description:
 */
public class Audience {

	//定义切点
	/**@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance(){}
	/**
	 * 	前置和后置通知
	 */

	/**@Before("performance()")
	public void silenceCellPhones(){
		System.out.println("Silencing cell phones");
	}
	@Before("performance()")
	public void takeSeats(){
		System.out.println("Taking seats");
	}
	@AfterReturning("performance()")
	public void applause(){
		System.out.println("CLAP CLAP");
	}
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("Demanding a refund");
	}
	/**
	 * 环绕通知
	 */
	public void watchPerformance(ProceedingJoinPoint jp){
		try{
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP CLAP");
		}catch (Throwable e){
			System.out.println("Demanding a refund");
		}
	}
	/**
	 * 调用proceed()方法，可以执行被通知的方法，多次调用可以实现重试逻辑
	 * 不调用会阻塞对被通知方法的调用
	 */
}
