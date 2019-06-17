package soundsystem;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: czw
 * @CreateTime: 2019-06-15 15:38
 * @UpdeteTime: 2019-06-15 15:38
 * @Description:
 */
@Configuration
//启用组件扫描，默认会扫描与配置类相同的包,使用basePackages可以配置多个包，不方便重构
//使用
//@ComponentScan(basePackages = {"soundsystem","video"})
//指定类所在的包会作为组件扫描的基础包，可以使用空接口来标记包
//@ComponentScan(basePackageClasses = {CDPlayConfig.class})
public class CDPlayConfig {
}
