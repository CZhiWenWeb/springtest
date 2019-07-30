package com.dynamic.dynamic.druid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;

    private static final Logger logger= LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    private ConversionService conversionService=new DefaultConversionService();
    private PropertyValue dataSourcePropertyValues;

    /**数据源*/
    private DataSource defaultDataSource;
    private Map<String,DataSource> customDataSource=new HashMap<>();
    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<Object,Object> targetDataSources=new HashMap<>();
//        将主数据源添加到更多数据源中
        targetDataSources.put("dataSource",defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
//        添加更多数据源
        targetDataSources.putAll(customDataSource);
        for (String key:customDataSource.keySet()
             ) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
//        创建DynamicDataSource
        GenericBeanDefinition beanDefinition=new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
    }
}
