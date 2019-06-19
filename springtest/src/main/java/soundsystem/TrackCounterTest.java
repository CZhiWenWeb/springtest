package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 14:58
 * @UpdeteTime: 2019-06-17 14:58
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
	@Rule
	public final StandardOutputStreamLog log=new StandardOutputStreamLog();
	@Autowired
	private CompactDisc cd;
	@Autowired
	private TrackCounter counter;

}
