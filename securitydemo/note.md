1.启动springboot项目时java.lang.AbstractMethodError: null
在使用springcloud的时候运行报这个错,原因是版本冲突导致的,在idea中创建springcloud项目的时候,这里默认是${spring-cloud.version},但是如果你使用的
是高版本的springcloud的话还好,不会有什么问题,但是当你把parent版本下调到2.1.0以下的时候,再使用一些组件比如eureka的时候就会发现报错了,就算添加依赖
的时候明确指出了组件的版本号,它也不会跟据你的版本号下载,而是下载2.1.0的
将spring-cloud-dependencies的version改为Finckley.RELEASE

2.springboot启动报错required a bean of type 'com.czw.code.properties' that could not be found.
多模块springboot项目可以将包名都设置为com.{}.**,然后在@SpringBootApplication添加scanBasePackge=
"com.{}"即可


