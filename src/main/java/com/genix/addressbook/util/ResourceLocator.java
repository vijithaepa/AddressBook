package com.genix.addressbook.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Use to load Spring context beans and message resources.
 */
public class ResourceLocator {

	private static ApplicationContext appContext;

	private ResourceLocator() {

	}

	public static ApplicationContext getContextInstance() {
		if (appContext == null) {
			appContext = new ClassPathXmlApplicationContext(new String[] { "spring/applicationContext.xml" });
		}

		return appContext;
	}

	public static Object getBean(String beanName) {
		return getContextInstance().getBean(beanName);
	}

	public static String getI18NMessage(String key) {
		ApplicationContext appContext = getContextInstance();
		return appContext.getMessage(key, null, "Error reading resource", null);
	}

}
