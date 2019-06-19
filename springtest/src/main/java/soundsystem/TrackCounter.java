package soundsystem;

import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-06-17 11:24
 * @UpdeteTime: 2019-06-17 11:24
 * @Description:
 */
@Aspect
public class TrackCounter {
	private Map<Integer,Integer> trackCounts=
			new HashMap<>();
	public void countTrack(int trackNumber){
		int currentCount=getPlayCount(trackNumber);
		trackCounts.put(trackNumber,currentCount+1);
	}

	private int getPlayCount(int trackNumber) {
		return trackCounts.containsKey(trackNumber)?trackCounts.get(trackNumber):0;
	}


}
