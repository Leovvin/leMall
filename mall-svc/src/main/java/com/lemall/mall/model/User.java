package com.lemall.mall.model;

import com.lemall.mall.type.Sex;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    Long id;
    String name;
    Sex sex;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
