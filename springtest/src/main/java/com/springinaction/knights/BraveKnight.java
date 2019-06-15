package com.springinaction.knights;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 16:20
 * @UpdeteTime: 2019-06-14 16:20
 * @Description:
 */
public class BraveKnight implements Knight{
	private Quest quest;
	public BraveKnight(Quest quest){
		this.quest=quest;
	}
	@Override
	public void embarkOnQuest() {
		quest.embark();
	}
}
