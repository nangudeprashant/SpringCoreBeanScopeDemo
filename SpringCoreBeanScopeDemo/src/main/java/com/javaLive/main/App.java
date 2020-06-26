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
 * Above are scopes at core level and we are only explaining them here.
 * Below are the scopes at web level i.e. they are applicable for web based spring projects.
 * We will study them in web based spring project.
 *   
 * Spring bean scopes applicable for web based project are as follows:
 * 
 * request-  Spring bean configured as request scope instantiates the bean for a single HTTP request. 
 * Since HTTP requests are available only in web applications this scope is valid only for web-aware spring 
 * application context.
 * 
 * session – Spring Beans configured as session scope lives through the HTTP session. Similar to request scope,
 * it is applicable only for web aware spring application contexts.
 * 
 * global_session- This scope is equal to the  session scope on portlet applications. 
 * This scope is also applicable only for web aware spring application contexts. 
 * If this is global_session is used in normal web application (not in portlet), 
 * then it will behave as session scope and there will not be any error.
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
