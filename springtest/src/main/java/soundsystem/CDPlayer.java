package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-06-15 16:42
 * @UpdeteTime: 2019-06-15 16:42
 * @Description:
 */
@Component
public class CDPlayer implements MediaPlayer{
	private CompactDisc cd;
	//@Autowired//@Autowired(required=false)当没有bean时，会被设置为空不会抛出异常
	//并让其处于非装配状态
	public CDPlayer(CompactDisc cd){
		this.cd=cd;
	}

	@Override
	public void play() {
		cd.play();
	}

	public CompactDisc getCd() {
		return cd;
	}
}
