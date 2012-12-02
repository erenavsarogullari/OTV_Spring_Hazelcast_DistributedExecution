package com.onlinetechvision.exe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application class starts the application
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 *
 */
public class Application {
	
	/**
     * Starts the application
     *
     * @param  String[] args
	 *
     */
	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Starter starter = (Starter) context.getBean("starter");		
		starter.start();
	}
	
}
