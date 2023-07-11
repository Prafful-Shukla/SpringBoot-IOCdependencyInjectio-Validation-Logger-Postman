//this will helps to face the error in production environment.
package com.example.api.thfeb.demoapi4thfeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	
	
	@GetMapping("/getNotificationMsg")
	public String getNotified() {
		
//	 System.out.print("Error details1.......................");
//	 System.out.print("Error details2.......................");
//	 System.out.print("Error details3.......................");
//	 System.out.print("Error details4.......................");
		//this wont give us time ,where the error is comming from and other details like below method gives
	 	
	 	//these are 5 logger level
		logger.error("This is error log"); //1 line persec per user//in console
		logger.warn("This is warn log"); //10 line persec per user
		logger.info("This is info log"); //100 line persec per user
		logger.debug("This is debug log"); //350 line persec per user
		logger.trace("This is trace log"); //1000 line persec per user
		
		
		//with this we have control over log
		//in application .properties we have already set logger level to debug so 
		//which all logger willl be printed here?
		
		
		return "Hi ";//in postman
	}
	
	//environments;
	// dev ---- developer 10 user                developer
	//tst - qa - testing team - 5 user           testing
	// stg --- uat --- 2 user                    staging        uat= (user acceptance testing)
	//prod --- prod most stable env              production
	
	//in production there will be 1000s of trace log per USER and as there will be many user
	//it will be unable to handle 2-3gb of logs so we will go for less logs(generally we go for info or error)
	
	
	//zomato
	//user in developer team dev --- 20 user
	//user in staging - 10k
	//production --- 10crore if log level is set to trace 50gb log data we can not go for this . go for info or warn logs
	//just imagine the amount of processing toncatch that error? so go for info or error
	
	//when i am checking for only info in allicationproperties 
	//	Error details1.......................Error details2.......................Error details3.......................Error details4.......................2023-07-11T16:42:23.227+05:30 ERROR 23984 --- [nio-8085-exec-1] c.e.a.thfeb.demoapi4thfeb.CarController  : This is error log
	//	2023-07-11T16:42:23.227+05:30  WARN 23984 --- [nio-8085-exec-1] c.e.a.thfeb.demoapi4thfeb.CarController  : This is warn log
	//	2023-07-11T16:42:23.227+05:30  INFO 23984 --- [nio-8085-exec-1] c.e.a.thfeb.demoapi4thfeb.CarController  : This is info log
	//i am getting this not error log?? why???
	//
	
	
	
}
