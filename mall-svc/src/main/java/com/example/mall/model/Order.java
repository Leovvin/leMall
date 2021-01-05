package com.example.mall.model;

import com.example.mall.type.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    Long id;
    Product product;
    User user;
    int amount;
    OrderStatus status;
    LocalDateTime create_time;
    LocalDateTime update_time;
}
