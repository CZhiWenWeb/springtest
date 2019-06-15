package com.springinaction.knights;

import static org.mockito.Mockito.*;
import org.junit.Test;
/**
 * @Author: czw
 * @CreateTime: 2019-06-14 16:40
 * @UpdeteTime: 2019-06-14 16:40
 * @Description:
 */
public class BravenKnightTest {
	@Test
	public void k(){
		Quest mockQuest=mock(Quest.class);//创建mock Quest
		BraveKnight knight=new BraveKnight(mockQuest);//注入mock Quest
		knight.embarkOnQuest();
		//验证quest的mock实现的embark()方法尽被调用一次
		verify(mockQuest,times(1)).embark();
	}
}
