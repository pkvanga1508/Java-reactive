package com.rp.operators.util;

import com.rp.util.Utils;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = Utils.faker().name().fullName();
        this.age = Utils.faker().random().nextInt(1, 30);
    }
}
