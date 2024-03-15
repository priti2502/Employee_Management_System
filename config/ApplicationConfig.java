package com.qsp.employee_management_system.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
	@Bean
	public Docket getDocket() {
    Contact contact=new Contact("Priti", "priti12.com", "priti@gmail.com");
    List<VendorExtension> extensions=new ArrayList<VendorExtension>();
    ApiInfo apiInfo=new ApiInfo("EMS", "This application is used to manage the employees", "version 1.0", "www.ems.com", contact, "qsp001","www.qsp001.com",extensions);
    return new Docket(DocumentationType.SWAGGER_2).select()
    		.apis(RequestHandlerSelectors
    		.basePackage("com.qsp.employee_management_system"))
    		.build().apiInfo(apiInfo).useDefaultResponseMessages(false);
    
		
	}
	

}
