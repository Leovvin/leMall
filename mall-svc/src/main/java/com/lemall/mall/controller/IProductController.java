package com.lemall.mall.controller;

import com.lemall.mall.dto.ResponseEntity;

public interface IProductController {

    ResponseEntity<String> book(String productId, Integer amount);
}
