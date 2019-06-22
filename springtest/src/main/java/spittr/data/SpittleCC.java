package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-06-20 15:41
 * @UpdeteTime: 2019-06-20 15:41
 * @Description:
 */
@Component
public class SpittleCC implements SpittleRepository{
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittleList=new ArrayList<>();
		for (int i=0;i<count;i++)
			spittleList.add(new Spittle(String.valueOf(i),new Date(),Double.valueOf(i),Double.valueOf(i)));
		return spittleList;
	}
}
