package soundsystem.javaconfig;

import org.springframework.context.annotation.Bean;
import soundsystem.CompactDisc;
import soundsystem.Revolver;
import soundsystem.SgtPeppers;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 09:36
 * @UpdeteTime: 2019-06-17 09:36
 * @Description:
 */
public class SgtPeppersConfig {
	@Bean
	public CompactDisc randomBeatlesCD(){
		int choice=(int) Math.floor(Math.random()*4);
		if (choice==0)
			return new SgtPeppers();
		else
			return new Revolver();
	}

	public static void main(String[] args) {
		SgtPeppersConfig s=new SgtPeppersConfig();
		for (int i=3;i>0;i--)
			s.randomBeatlesCD().play();
	}
}
