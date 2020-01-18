package org.kimbs.demo.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kimbs.demo.document.Employee;
import org.kimbs.demo.document.code.JobCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ComponentScan(basePackages = {"org.kimbs.demo.repository"})
public class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    private Collection<Employee> db;

    @BeforeEach
    void setUp() {
        // arrange
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

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
        db = mongoTemplate.insertAll(employees);
    }

    @AfterEach
    void tearDown() {
        mongoTemplate.remove(new Query(), Employee.class);
    }

    @Test
    @DisplayName("모든 종업원 찾기")
    void testWhenRepositoryIsEmptyAtFindAllEmployee() {
        // actual
        Flux<Employee> employeeFlux = employeeRepository.findAllEmployee().log();

        List<Employee> actual = employeeFlux.collectList().block();

        // assert
        assertThat(actual).hasSize(14);
    }

    @Test
    @DisplayName("급여가 2000 이상인 종업원 찾기")
    void testFindEmployeeGreaterThanSalary() {
        // actual
        Flux<Employee> employeeFlux = employeeRepository.findEmployeeGreaterThanSalary(2000).log();

        List<Employee> actual = employeeFlux.collectList().block();

        // assert
        assertThat(actual).hasSize(6).extracting(e -> e.getName()).contains("JONES", "BLAKE", "CLARK", "SCOTT", "KING", "FORD");
    }

    @Test
    @DisplayName("Manager가 없는 종업원 찾기")
    void testFindEmployeeNotExistsManager() {
        // actual
        Flux<Employee> employeeFlux = employeeRepository.findEmployeeNotExistsManager().log();

        List<Employee> actual = employeeFlux.collectList().block();

        // assert
        assertThat(actual).hasSize(1).extracting(e -> e.getName()).contains("KING");
    }

    @Test
    @DisplayName("이름에 M과 S가 포함된 종업원 찾기")
    void testFindEmployeeByNameContainsMorS() {
        // actual
        Flux<Employee> employeeFlux = employeeRepository.findEmployeeByNameContainsMorS().log();

        List<Employee> actual = employeeFlux.collectList().block();

        // assert
        assertThat(actual).hasSize(3).extracting(e -> e.getName()).contains("SMITH", "JAMES", "ADAMS");
    }

    @Test
    @DisplayName("종업원을 급여를 내림차순으로 이름을 오름차순으로 정렬하기")
    void testFindByEmployeeByOrderBySalaryDescNameAsc() {
        // actual
        Flux<Employee> employeeFlux = employeeRepository.findByEmployeeByOrderBySalaryDescNameAsc().log();

        List<Employee> actual = employeeFlux.collectList().block();

        // assert
        // salary desc, name asc;
        List<Employee> expected = db.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                        .thenComparing(Employee::getName)).collect(Collectors.toList());

        assertThat(actual).hasSize(14);
        assertIterableEquals(expected, actual);
    }

    @Test
    @DisplayName("급여가 제일 많은 종업원 찾기")
    void testFindByEmployeeByMostSalary() {
        // actual
        Mono<Employee> employeeMono = employeeRepository.findByEmployeeByMostSalary().log();

        Employee actual = employeeMono.block();

        // assert
        assertEquals("KING", actual.getName());
        assertEquals(JobCode.PRESIDENT.getCode(), actual.getJob());
        assertEquals(5000, actual.getSalary());
    }
}
