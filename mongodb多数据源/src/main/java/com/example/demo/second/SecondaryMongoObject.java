package com.example.demo.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by archerlj on 2017/6/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "first_mongo")
public class SecondaryMongoObject {
    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}
