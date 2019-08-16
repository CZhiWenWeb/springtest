package com.hello.dynamicdatasource.annotation;

import java.lang.annotation.*;

/**
 * @Author: czw
 * @CreateTime: 2019-08-15 09:04
 * @UpdeteTime: 2019-08-15 09:04
 * @Description:
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	/**
	 * @return the database you want to switch
	 */
	String name();
}
