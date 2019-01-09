package com.models;

import com.validators.UniqId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @UniqId
    private String id;
    private String name;
    private String age;
}
