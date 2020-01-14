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
@Document(collection = "BONUS")
public class Bonus {

    @MongoId
    private ObjectId id;

    @Field("EMPLOYEE_NAME")
    private String employeeName;

    @Field("JOB")
    private String job;

    @Field("SALARY")
    private int salary;

    @Field("COMM")
    private int comm;
}
