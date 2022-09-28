package com.springboot.workers.jdbcexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
		System.out.println("spring boot n-tier app with JDBC connectivity and MySQL works!!!");
	}

}
