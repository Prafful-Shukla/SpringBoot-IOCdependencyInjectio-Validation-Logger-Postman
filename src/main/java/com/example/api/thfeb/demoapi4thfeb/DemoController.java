package com.example.api.thfeb.demoapi4thfeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	DemoConfig obj;
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/demoController/getConfig")
	public String getConfig() {
		
		
		
		logger.info("LOGGER 333: " + obj);
		return obj.getConfig();
	}
	//LOGGER 333: com.example.api.thfeb.demoapi4thfeb.DemoConfig@5814616a
	//LOGGER 333: com.example.api.thfeb.demoapi4thfeb.DemoConfig@5c9096a1
	//LOGGER 333: com.example.api.thfeb.demoapi4thfeb.DemoConfig@2b870a7f
	//LOGGER 333: com.example.api.thfeb.demoapi4thfeb.DemoConfig@43f17f3a
	

}
