package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 17:27
 * @UpdeteTime: 2019-06-14 17:27
 * @Description:
 */
public class Minstrel {
	private PrintStream stream;
	public Minstrel(PrintStream stream){
		this.stream=stream;
	}
	public void singBeforeQuest(){
		stream.println("FFF,the knight is so brave");
	}
	public void singAfterQuest(){
		stream.println("Tee,did embark on a quest!");
	}
}
