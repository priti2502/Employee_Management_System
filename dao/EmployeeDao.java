package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.employee_management_system.Repo.EmployeeRepo;
import com.qsp.employee_management_system.dto.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {

		return repo.save(employee);

	}

	public Employee findEmployee(int id) {

		Optional<Employee> optional = repo.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	public List<Employee> findAllEmployee() {

		return repo.findAll();

	}

	public Employee deleteEmployee(Employee employee) {

		repo.delete(employee);
		return employee;

	}

	public List<Employee> saveAllEmployee(List<Employee> list) {
		return repo.saveAll(list);
	}

	public Employee findByPhone(long phone) {

		return repo.findEmployeeByPhone(phone);

	}

	public Employee findByEmail(String email) {
		// return repo.findEmployeeByEmail(email);
		return repo.getEmployeeByEmail(email);

	}

	public List<Employee> findByAddress(String address) {

		return repo.employeeByAddress(address);

	}

	public List<Employee> findByName(String name) {
		return repo.employeeByName(name);
	}

	public List<Employee> salaryLessThan(double salary) {

		return repo.findEmployeeBySalaryLessThan(salary);
	}

	public List<Employee> salaryGreaterThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}

	public List<Employee> salaryBetween(double sal1, double sal2) {
		// TODO Auto-generated method stub
		return repo.employeesalaryBetween(sal1, sal2);

	}

	public List<Employee> employeeByGrade(char grade) {

		return repo.findEmployeeByGrade(grade);

	}
}
