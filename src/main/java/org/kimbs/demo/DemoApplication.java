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

		Employee e1 = new Employee(null, 7369, "SMITH", JobCode.CLERK.getCode(), 7902, LocalDateTime.now(), 800, null, 20);
		Employee e2 = new Employee(null, 7499, "ALLEN", JobCode.SALESMAN.getCode(), 7698, LocalDateTime.now(), 1600, 300, 30);
		Employee e3 = new Employee(null, 7521, "WARD", JobCode.SALESMAN.getCode(), 7698, LocalDateTime.now(), 1250, 500, 30);
		Employee e4 = new Employee(null, 7566, "JONES", JobCode.MANAGER.getCode(), 7839, LocalDateTime.now(), 2975, null, 20);
		Employee e5 = new Employee(null, 7654, "MARTIN", JobCode.SALESMAN.getCode(), 7698, LocalDateTime.now(), 1250, 1400, 30);
		Employee e6 = new Employee(null, 7698, "BLAKE", JobCode.MANAGER.getCode(), 7839, LocalDateTime.now(), 2850, null, 30);
		Employee e7 = new Employee(null, 7782, "CLARK", JobCode.MANAGER.getCode(), 7839, LocalDateTime.now(), 2450, null, 10);
		Employee e8 = new Employee(null, 7788, "SCOTT", JobCode.ANALYST.getCode(), 7566, LocalDateTime.now(), 3000, null, 20);
		Employee e9 = new Employee(null, 7839, "KING", JobCode.PRESIDENT.getCode(), null, LocalDateTime.now(), 5000, null, 10);
		Employee e10 = new Employee(null, 7844, "TURNER", JobCode.SALESMAN.getCode(), 7698, LocalDateTime.now(), 1500, 0, 30);
		Employee e11 = new Employee(null, 7876, "ADAMS", JobCode.CLERK.getCode(), 7788, LocalDateTime.now(), 1100, null, 20);
		Employee e12 = new Employee(null, 7900, "JAMES", JobCode.CLERK.getCode(), 7698, LocalDateTime.now(), 950, null, 30);
		Employee e13 = new Employee(null, 7902, "FORD", JobCode.ANALYST.getCode(), 7566, LocalDateTime.now(), 3000, null, 20);
		Employee e14 = new Employee(null, 7934, "MILLER", JobCode.CLERK.getCode(), 7782, LocalDateTime.now(), 1300, null, 10);

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
