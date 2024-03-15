package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;
import com.qsp.employee_management_system.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService service;

   @PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
	
	return service.saveEmployee(employee);
		
	}

   @GetMapping("/fetch")
   public ResponseEntity<ResponseStructure<Employee>> findEmployee(@RequestParam int id) {
	   return service.findEmployee(id);
		
	}
   
   @GetMapping("/fetchAll")
   public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		
		return service.findAllEmployee();
	}
   
   @DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) {
		
		return service.deleteEmployee(id);
		
	}
   
   @PutMapping("/update")
   public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee,@RequestParam int id) {
	   return service.updateEmployee(employee, id);
	   
 }
   
   @PostMapping("/saveall")
   public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(@RequestBody List<Employee>list){
	   return service.saveAllEmployee(list);
	   
	   
   }
   
   @PatchMapping("/updatephone")
   public ResponseEntity<ResponseStructure<Employee>> updatePhone(@RequestParam int id,@RequestParam long phone) {
	   return service.updatePhone(id,phone);
	   
   }
   
   @PatchMapping("/updateemail")
   public ResponseEntity<ResponseStructure<Employee>> updateEmail(@RequestParam int id,@RequestParam String email) {
	   return service.updateEmail(id,email);
	   
   }
   
   @PatchMapping("/updatesalary")
   public ResponseEntity<ResponseStructure<Employee>> updateSalary(@RequestParam int id,@RequestParam double salary) {
	   return service.updateSalary(id,salary);
	   
	   
   }
   
   
   @GetMapping("/findbyphone")
   public ResponseEntity<ResponseStructure<Employee>> findByPhone(@RequestParam long phone) {
	   
	   return service.findByPhone(phone);
	   
	   
   }
   
   
   @GetMapping("/findbyemail")
   public ResponseEntity<ResponseStructure<Employee>> findByEmail(@RequestParam String email) {
	   
	   return service.findByEmail(email);
	   
	   
   }

   @GetMapping("/findbyaddress")
   public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(@RequestParam String address){
	   return service.findByAddress(address);
   }
   
   @GetMapping("/findbyname")
   public ResponseEntity<ResponseStructure<List<Employee>>> findByName(@RequestParam String name){
	   return service.findByName(name);
   }
   
   @GetMapping("/salarylessthan")
   public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(@RequestParam double salary){
	   return service.salaryLessThan(salary);
   }
   
   @GetMapping("/salarygreaterthan")
   public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(@RequestParam double salary){
	   return service.salaryGreaterThan(salary);
   }

   @GetMapping("/salarybetween")
   public ResponseEntity<ResponseStructure<List<Employee>>> salaryBetween(double salary1,double salary2){
	   return service.salaryBetween(salary1,salary2);
	   
   }
   
   @GetMapping("/findbygrade")
   public ResponseEntity<ResponseStructure<List<Employee>>> employeeByGrade(char grade){
	   return service.employeeByGrade(grade);
	   
   }
}
