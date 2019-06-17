package soundsystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @Author: czw
 * @CreateTime: 2019-06-15 16:14
 * @UpdeteTime: 2019-06-15 16:14
 * @Description:
 */
//在测试开始的时候自动创建spring的应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//加载CDPlayerConfig中的配置
@ContextConfiguration(classes = CDPlayConfig.class)
public class CDPlayerTest {
	@Autowired
	CDPlayer cdPlayer;
	@Test
	public void shouldBeFind(){
		assertNotNull(cdPlayer);
	}
}
