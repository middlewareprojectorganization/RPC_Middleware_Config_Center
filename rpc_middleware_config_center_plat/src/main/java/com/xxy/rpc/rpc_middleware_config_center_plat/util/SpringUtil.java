package com.xxy.rpc.rpc_middleware_config_center_plat.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
 
	private static ApplicationContext applicationContext;
 
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
 
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		SpringUtil.applicationContext = applicationContext;
	}


}