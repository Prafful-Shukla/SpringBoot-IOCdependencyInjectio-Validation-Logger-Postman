package com.example.api.thfeb.demoapi4thfeb;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration("myConfig")//if i pas this string then bean name will not be created with class name.wow
public class DemoConfig {

	
	private static Logger logger = LoggerFactory.getLogger(DemoConfig.class);
	
	public String getConfig() {
		
		return "Config" + UUID.randomUUID();
	}
	
}
