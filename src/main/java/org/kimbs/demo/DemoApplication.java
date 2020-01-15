package org.kimbs.demo;

import org.kimbs.demo.document.Department;
import org.kimbs.demo.document.Employee;
import org.kimbs.demo.document.SalaryGrade;
import org.kimbs.demo.document.code.DepartmentCode;
import org.kimbs.demo.document.code.JobCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department d1 = new Department(null, DepartmentCode.ACCOUNTING.getDepartmentId(), DepartmentCode.ACCOUNTING.name(), "NEW YORK");
		Department d2 = new Department(null, DepartmentCode.RESEARCH.getDepartmentId(), DepartmentCode.RESEARCH.name(), "DALLAS");
		Department d3 = new Department(null, DepartmentCode.SALES.getDepartmentId(), DepartmentCode.SALES.name(), "CHICAGO");
		Department d4 = new Department(null, DepartmentCode.OPERATIONS.getDepartmentId(), DepartmentCode.OPERATIONS.name(), "BOSTON");

		SalaryGrade sg1 = new SalaryGrade(null, 1, 700, 1200);
		SalaryGrade sg2 = new SalaryGrade(null, 2, 1201, 1400);
		SalaryGrade sg3 = new SalaryGrade(null, 3, 1401, 2000);
		SalaryGrade sg4 = new SalaryGrade(null, 4, 2001, 3000);
		SalaryGrade sg5 = new SalaryGrade(null, 5, 3001, 9999);

	}
}
