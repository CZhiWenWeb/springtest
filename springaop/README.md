java平台上的AOP实现机制：

1.动态代理
    在运行期间为相应的接口动态生成对应的代理对象。将横切关注点逻辑封装
    到动态代理的InvocationHandler中，在系统运行期间根据横切关注点需要
    织入的模块位置，将横切逻辑植入到相应的代理类中，以动态代理类为载体的
    横切逻辑。
    动态代理是在运行期间使用反射，相对于编译后的静态类性能稍差，且只针
    对接口有效

2.动态字节码增强
    java虚拟机能运行任何符合规则的Java class文件。通常的class文件都是
    从javac编译器编译而成的，也可以使用ASM或者CGLIB等java工具库，在程序
    运行期间动态构建字节码的class文件。
    在这样的前提下，我们可以为需要织入横切逻辑的模块类在运行期间，通过字节码
    增强技术，为这些系统模块类生成相应的子类，而将横切逻辑加到这些子类中。
    这样做不受限与接口，但对于无法重写的final方法无法扩展。

3.自定义类加载器
    所有的java程序的class都要通过相应的类加载器（classLoader）加载到jvm之后
    才可以运行。默认的类加载器会读取class字节码文件，然后按照class字节码规范，
    解析并加载这些class文件到虚拟机运行。
    我们可以通过自定义的类加载器在加载class文件期间将横切逻辑添加到系统模块类
    的现有逻辑中，将改动后的class交给jvm。在某些应用服务器控制整个类加载体系
    的场景下使用可能会造成问题。
4.AOL扩展
    最强大的方法，代价是重新学习一门扩展旧有语言的AOL或全新的AOL