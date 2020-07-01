参考：https://blog.csdn.net/zhang6622056/article/details/87286498
cglib是一套java动态代理实现框架，基于继承实现，意味着final，private
相关的method无法被代理。基于asm框架对class字节码编辑改动，从而达到动态
代理的目的。被代理类没有实现接口的情况下cglib为首选

代理形式主要有：
1.FixedValue

2.InvocationHandler

3.LazyLoader

4.MethodInterceptor

5.Dispatcher

6.NoOp
