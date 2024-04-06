package com.rp.operators.util;

import com.rp.util.Utils;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.name = Utils.faker().name().fullName();
        this.userId = userId;
    }
}
