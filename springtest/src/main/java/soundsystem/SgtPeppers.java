package soundsystem;

import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-06-15 15:33
 * @UpdeteTime: 2019-06-15 15:33
 * @Description:
 */
//组件扫描注解，默认不启用，需要显示配置一下spring,
	//spring会根据类名为其指定一个ID，默认将首字母小写
	//括号内可以重新设置id
@Component("lonelyHear")
public class SgtPeppers implements CompactDisc{
	private String title="SgtPeppers's Band";
	private String artist="The Beans";
	@Override
	public void play() {
		System.out.println("Playing"+title+"by"+artist);
	}
}
