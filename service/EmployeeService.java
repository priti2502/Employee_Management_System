package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.exception.EmailNotFound;
import com.qsp.employee_management_system.exception.IdNotFound;
import com.qsp.employee_management_system.exception.NoDataAvailable;
import com.qsp.employee_management_system.exception.PhoneNotFound;
import com.qsp.employee_management_system.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		double salary = employee.getSalary();

		if (salary < 10000) {
			employee.setGrade('D');
		} else if (salary >= 10000 && salary < 20000) {
			employee.setGrade('C');
		} else if (salary >= 20000 && salary < 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Save Successful!!!");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(dao.saveEmployee(employee));
		// return structure ;
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		Employee employee = dao.findEmployee(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Found Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.FOUND);
		} else {

			throw new IdNotFound("Employee Id not found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		List<Employee> list = dao.findAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (list.isEmpty()) {

			throw new NoDataAvailable("Employee not found");
		} else {
			structure.setMessage("Data FOund Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(HttpStatus.FOUND);

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.findEmployee(id);

		if (employee != null) {
			dao.deleteEmployee(employee);
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Data Deleted Successful!!!");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {

			throw new IdNotFound("Employee Id not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee, int id) {
		Employee employee1 = dao.findEmployee(id);
		if (employee1 != null) {
			employee.setId(id);
			return saveEmployee(employee);
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Update Successful!!!");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.OK);
		} else {
//			
//			structure.setMessage("Data Not Update!!!");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); //structure.setStatus(404);
//			structure.setData(employee);
//			return structure ;
			throw new NoDataAvailable("Employee not found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(List<Employee> list) {
		for (Employee employee : list) {
			double salary = employee.getSalary();

			if (salary < 10000) {
				employee.setGrade('D');
			} else if (salary >= 10000 && salary < 20000) {
				employee.setGrade('C');
			} else if (salary >= 20000 && salary < 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}

		}
		list = dao.saveAllEmployee(list);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		structure.setMessage("Save Successful!!!");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(list);
		// return structure ;
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			return saveEmployee(employee);
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) 
		{
			structure.setMessage("Update Phone Sucessful!!!");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(employee);
			
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.OK);
		} else {
			throw new IdNotFound("Employee Id not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.findEmployee(id);
		if (employee != null) {
			return saveEmployee(employee);
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Update Phone Sucessful!!!");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.OK);
		}

		else {

			throw new IdNotFound("Employee Id not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.findEmployee(id);
		employee.setSalary(salary);

		if (salary < 10000) {
			employee.setGrade('D');
		} else if (salary >= 10000 && salary < 20000) {
			employee.setGrade('C');
		} else if (salary >= 20000 && salary < 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Update Salary Sucessful!!!");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {

			throw new IdNotFound("Employee Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Found Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new PhoneNotFound("Employee Phone not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (employee != null) {
			structure.setMessage("Email Found Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new EmailNotFound("Employee Email not found");

		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(String address) {
		List<Employee> employee = dao.findByAddress(address);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Data Found By Address Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);
			// return structure ;
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}

		else {

			throw new NoDataAvailable("Employee address not found");

		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> employee = dao.findByName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Found By Name!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}

		else {

			throw new NoDataAvailable("Employee name not found");

		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(double salary) {
		// TODO Auto-generated method stub
		List<Employee> employee = dao.salaryLessThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Data found Successful");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		} else {

			throw new NoDataAvailable("Employee salary not found");

		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(double salary) {
		// TODO Auto-generated method stub
		List<Employee> employee = dao.salaryGreaterThan(salary);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Found Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		} else {

			throw new NoDataAvailable("Employee salary not found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryBetween(double sal1, double sal2) {

		List<Employee> employee = dao.salaryBetween(sal1, sal2);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Found Successful!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		} else {

			throw new NoDataAvailable("Employee salary not found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> employeeByGrade(char grade) {
		// TODO Auto-generated method stub
		List<Employee> employee = dao.employeeByGrade(grade);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();
		if (employee != null) {
			structure.setMessage("Data Found By Grade!!!");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		} else {

			throw new NoDataAvailable("Employee not found with grade");

		}

	}

}
