package com.qsp.employee_management_system.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_management_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{	
	Employee findEmployeeByPhone(long phone);
    //Employee findEmployeeByEmail(String email);
	Employee getEmployeeByEmail(String email);

	@Query("SELECT e FROM Employee e WHERE e.address=?1")
	List<Employee> employeeByAddress(String address);
	
	@Query("SELECT e FROM Employee e WHERE e.name=?1")
	List<Employee> employeeByName(String name);
	List<Employee> findEmployeeBySalaryLessThan(double salary);
	List<Employee> findEmployeeBySalaryGreaterThan(double salary);
	
	@Query("SELECT e FROM Employee e WHERE e.salary between ?1 AND ?2")
	List<Employee> employeesalaryBetween(double sal1, double sal2);
	List<Employee> findEmployeeByGrade(char grade);
	

}
