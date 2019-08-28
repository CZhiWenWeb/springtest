package com.xyx.shiro.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 16:06
 * @UpdeteTime: 2019-08-26 16:06
 * @Description:
 */
@Getter
@Setter
public class BaseDto implements Serializable {

	private static final long serialVersionUID = 3860807153253646754L;
	@Transient
	@Min(value = 1, message = "当前页数不能小于1")
	private Integer page=1;
	@Transient
	@Min(value = 1, message = "每页条数不能小于1")
	@Max(value = 50, message = "每页条数不能大于于50")
	private Integer rows=10;
	//排序的列名
	@Transient
	private String sidx;
	//排序规则（Desc or Esc）
	@Transient
	private String sord;

}
