### spring 属性注入循环依赖解决
1. spring中的属性注入的循环依赖是通过三个Map进行解决的
    > Map(earlySingletonObjects、singletonFactories、singletonObjects)

https://blog.csdn.net/qq271859852/article/details/105181422
### spring 构造方法循环依赖解决
1. spring中的构造方法注入依赖的循环是通过@Lazy进行解决的
    > org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBeanInstance
    