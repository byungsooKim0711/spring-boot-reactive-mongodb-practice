package org.kimbs.demo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SALARY_GRADE")
public class SalaryGrade {

    @MongoId
    private ObjectId id;

    @Field("GRADE")
    private int grade;

    @Field("LOW_SALARY")
    private int lowSalary;

    @Field("HIGH_SALARY")
    private int highSalary;
}
