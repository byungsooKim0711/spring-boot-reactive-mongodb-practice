package org.kimbs.demo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "EMPLOYEE")
public class Employee {

    @MongoId
    private ObjectId id;

    @Field("EMPLOYEE_NUMBER")
    private int employeeNumber;

    @Field("NAME")
    private String name;

    @Field("JOB")
    @Indexed(name = "IDX_EMPLOYEE_JOB")
    private String job;

    @Field("MANAGER")
    private Integer manager;

    @Field("HIRE_DATE")
    private LocalDateTime hireDate;

    @Field("SALARY")
    private Integer salary;

    @Field("COMM")
    private Integer comm;

    @Field("DEPARTMENT_ID")
    private Integer departmentId;
}
