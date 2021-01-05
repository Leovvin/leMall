package com.example.mall.controller;

import com.example.mall.dto.ResponseEntity;

public interface IProductController {

    ResponseEntity<String> book(String productId, Integer amount);
}
