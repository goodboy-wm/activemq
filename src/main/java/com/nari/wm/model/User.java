package com.nari.wm.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class User implements Serializable {

    @NonNull
    @Size(min = 0,max = 20,message = "字符串长度最大20个字符")
    private String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
