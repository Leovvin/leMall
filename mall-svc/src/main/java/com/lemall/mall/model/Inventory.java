package com.lemall.mall.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Inventory {
    Long id;
    Product product;
    Integer stock;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
