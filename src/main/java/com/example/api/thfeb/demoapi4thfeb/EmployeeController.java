package com.example.api.thfeb.demoapi4thfeb;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
//this is the best validation use in companies u can add in resume

@RestController
public class EmployeeController {

	//singleton -- means only one objects of this class can be created
	//prototype -- means multiples of this type can created
	
	/* create api for employee management
	 * 1) add the employee details --> INPUT: employee object, output: void
	 * 2) update the employee details --> input: employee detail to be updated, output: employee object 
	 * 3) delete the employee details --->input : employee id , output : boolean| employee| void
	 * 4) get the employee details ------> input : employee id , output : employee object
	 * */
	
	public static int count =1;
	
	HashMap<Integer,Employee> employeeMap = new HashMap<>();
	
	
	@PostMapping("/employee/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		//@requestBody this is going to map the http request from postman to the domain object i.Employee
		//without this we were facing issue that name age gender we provided didnt map to object id 1 other things like name,gender,age was showing null so
		System.out.println(this);
			
		employee.setId(count++);
			employeeMap.put(employee.getId(), employee);
			return employee;
	}
	
	 
	
	
	//in update if we just update the email of some id using POST then other field will be updated to null
	//so we need to handle that case;
	
	
	
	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
		System.out.println(this);
		if(employee.getId() == null) {
			throw new Exception("id is not present for the employee to be updated ");
		}
		
		if(!employeeMap.containsKey(employee.getId())) {
			throw new Exception("Employee is not present");
		}
		
		
		
		employeeMap.put(employee.getId(), employee);
		return employee;
	}
	//above we r requesting a whole employing object and then we r changing with object with that id
	
	@DeleteMapping("/employee/delete/{id}")
	public Employee deleteEmployee(@PathVariable("id")int id) {
		System.out.println(this);
		return employeeMap.remove(id);
	}
	
	//but in this if we delete the id there will be no person with that id
	
	@GetMapping("/employee/get/all")
	public  List<Employee >getEmployee() {
		System.out.println(this);
		return employeeMap.values().stream().collect(Collectors.toList());
		
	}
	
	
	
	@GetMapping("/getValue")
	public Integer getListOfNumbers() {
		return null;
		
	}
	
	
//	 "id":3,
//	    "name":"rahul3",
//	    "age":23,
//	    "designation":null,
//	    "email":"rahul3@gmail.com",
//	    "gender":"MALE"
	
	//if i am passing some extra info from postman like "sirname":"shukla" 
	//it wont givee errr its just it wont map 
	
	//while updating we were checking if id present or not etc
	//there is no manadtory check like designation ,gender is must without which u cannot update
	//so to add these checks
	//so we have spring dependecy 
	//spring-starter-validation
	//that has @valid and other annotations ..jakarta validation
	
//	all the method here are non static and we have not created any object
//	then who is creating this objects ,hitting api?
//	this object is created by spring but it does not mean it will create object for every class
//	all those classes which are annotated with @component on the top of it directly or indirectly is
	//eligbible to be created a bean by springboot springCOntainer
}
