package com.springinaction.knights.config;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import com.springinaction.knights.Quest;
import com.springinaction.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: czw
 * @CreateTime: 2019-06-14 17:34
 * @UpdeteTime: 2019-06-14 17:34
 * @Description:
 */
@Configuration
public class KnightConfig {
	@Bean
	public Knight knight(){
		return new BraveKnight(quest());
	}
	@Bean
	private Quest quest() {
		return new SlayDragonQuest(System.out);
	}
}
