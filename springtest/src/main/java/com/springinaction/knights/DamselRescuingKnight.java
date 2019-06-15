package com.springinaction.knights;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 16:13
 * @UpdeteTime: 2019-06-14 16:13
 * @Description:
 */
public class DamselRescuingKnight implements Knight{
	private RescueDamselQuest quest;
	public DamselRescuingKnight(){
		this.quest=new RescueDamselQuest();
	}
	@Override
	public void embarkOnQuest() {
		quest.embark();
	}
}
