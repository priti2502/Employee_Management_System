package com.qsp.employee_management_system.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="name cant' be blank")// only done on string type data
	@NotNull(message="name can't be null")//only done on string
	private String name;
	@NotBlank(message="address cant' be blank")
	@NotNull(message="address can't be null")
	private String address;
	@Column(unique=true)
	@Min(value=6000000000l)
	@Max(value=9999999999l)
	private long phone;
	@Column(unique=true)
	@Email(regexp = "[a-z-0-9._$]+@[a-z]+\\.[a-z]{2,3}",message="Invalid email")//only on string tyoe data
	private String email;
	@Min(value=1)
	private double salary;
	private char grade;
	//if phone number is string
	//@Pattern(regexp="[6-9][0-9]{9}",message="invalid")
	//String phone

}
