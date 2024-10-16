# 容器

Spring 中的容器主要分为两类，BeanFactory 和 ApplicationContext。
BeanFactory 是一个简单的容器，能完成 Bean 的实例化，Bean 的依赖注入。
ApplicationContext 功能比较丰富，支持国际化、发布事件、支持 BeanPostProcessor 的自动注册。

AnnotationConfigApplicationContext
