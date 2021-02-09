package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author candya
 * @version 1.0
 * @Description TODO
 * @create time 2021/2/8 14:41
 **/
@Component
@ConfigurationProperties(prefix = "book.author")
public class AuthorSetting {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
