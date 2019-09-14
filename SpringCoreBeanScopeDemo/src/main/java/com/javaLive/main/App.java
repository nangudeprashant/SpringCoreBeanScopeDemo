package com.javaLive.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaLive.beans.PrototypeBean;
import com.javaLive.beans.SingletonBean;

/**
 * @author Team JavaLive
 * This programs demonstrates scopes of Spring beans.
 * Singleton scopes bean refers to the same instance while prototype creates new instance for each time
 * when created each time.
 * The instances can be checked using == i.e. equals operator. 
 *
 */
public class App {
	public static void main(String[] args) {
		
		System.out.println("=====================Testing Singletone scoped bean.============================");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		SingletonBean singletonBeanA = (SingletonBean)context.getBean("singletonBean");
		System.out.println("First instance "+singletonBeanA);
		SingletonBean singletonBeanB = (SingletonBean)context.getBean("singletonBean");
		System.out.println("Second instance "+singletonBeanB);
		System.out.println("Is Singleton Bean A and singleton B are same ? " +(singletonBeanA==singletonBeanB));
		
		
		System.out.println("=====================Testing Prototype scoped bean.============================");
		AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("spring-config.xml");
		PrototypeBean prototypeBeanA = (PrototypeBean) context.getBean("prototypeBean");
		System.out.println("First instance "+prototypeBeanA);
		PrototypeBean prototypeBeanB = (PrototypeBean) context.getBean("prototypeBean");
		System.out.println("Second instance "+prototypeBeanB);
		System.out.println("Is Prototype Bean A and Prototype B are same ? " + (prototypeBeanA == prototypeBeanB));
		context1.registerShutdownHook();
		context.registerShutdownHook();

	}
}
