package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 11:42
 * @UpdeteTime: 2019-06-17 11:42
 * @Description:
 */
@Configuration
/**
 * 启用aspectJ自动代理
 */
@EnableAspectJAutoProxy
public class TrackCounterConfig {
	@Bean
	public CompactDisc stgPeppers(){
		BlankDisc cd=new BlankDisc();
		cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		cd.setArtist("The Beatles");
		List<String> tracks=new ArrayList<>();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("Whit a Little Help from My Friends");

		cd.setTracks(tracks);
		return cd;
	}
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
}
