package spittr;


import lombok.Data;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 17:16
 * @UpdeteTime: 2019-06-18 17:16
 * @Description:
 */
@Data
public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	public Spittle(String message,Date time){
		this(message,time,null,null);
	}
	public Spittle(String message,Date time,Double latitude
	,Double longitude){
		this.id=null;
		this.message=message;
		this.time=time;
		this.longitude=longitude;
		this.latitude=latitude;
	}
	@Override
	public boolean equals(Object that){
		return EqualsBuilder.reflectionEquals(this,that);
	}
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
