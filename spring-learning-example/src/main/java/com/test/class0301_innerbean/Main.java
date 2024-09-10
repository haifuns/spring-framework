package com.test.class0301_innerbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024/1/18 22:52
 */
public class Main {

	public class J {
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.register(Main.class);
		context.register(J.class);
		context.refresh();
		System.out.println(context.getBean(J.class));

//		Spring Bean 实例化过程会推断构造方法，使用提供的构造方法，如何没有则反射。
//		J 是一个非静态内部类，并且没有使用 public 访问修饰符。这意味着它只能在其所在类 Main 的作用域内被访问。
//		因此要想 J 可以实例化，可以使用 public 访问修饰符，或者将 J 设置为静态内部类。
	}
}