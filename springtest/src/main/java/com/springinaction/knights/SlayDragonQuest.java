package com.springinaction.knights;

import java.io.PrintStream;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 16:55
 * @UpdeteTime: 2019-06-14 16:55
 * @Description:
 */
public class SlayDragonQuest implements Quest{
	private PrintStream  stream;
	public SlayDragonQuest(PrintStream stream){
		this.stream=stream;
	}
	@Override
	public void embark() {
		stream.println("EK on quest");
	}
}
