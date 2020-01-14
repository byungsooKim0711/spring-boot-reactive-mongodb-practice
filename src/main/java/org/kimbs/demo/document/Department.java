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
@Document(collection = "DEPARTMENT")
public class Department {

    @MongoId
    private ObjectId id;

    @Field("DEPARTMENT_ID")
    private Integer departmentId;

    @Field("NAME")
    private String name;

    @Field("DESCRIPTION")
    private String description;
}
