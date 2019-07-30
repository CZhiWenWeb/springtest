package com.dynamic.dynamic.aspect;

import com.dynamic.dynamic.annotation.TargetDateSource;
import com.dynamic.dynamic.druid.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: czw
 * @CreateTime: 2019-07-30 17:38
 * @UpdeteTime: 2019-07-30 17:38
 * @Description:
 */
@Aspect
/**数字代表加载优先级，数字越低优先级越高，默认为int最大值*/
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger= LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("annotation(ds)")
    public void changeDataSource(JoinPoint point, TargetDateSource ds){
        String dsId=ds.name();
        if (!DynamicDataSourceContextHolder.containDataSource(dsId)){
            logger.error("数据源[{}]不存在，使用默认数据源",ds.name(),point.getSignature());
        }else {
            logger.debug("Use DataSource:{}",ds.name(),point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(ds.name());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point,TargetDateSource ds){
        logger.debug("Revert DataSource:{}",ds.name(),point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
