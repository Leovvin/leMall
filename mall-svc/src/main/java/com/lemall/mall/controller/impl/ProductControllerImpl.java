package com.lemall.mall.controller.impl;

import com.lemall.mall.controller.IProductController;
import com.lemall.mall.dto.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("product")
public class ProductControllerImpl implements IProductController {
    @Override
    @GetMapping("book")
    public ResponseEntity<String> book(@PathParam("productId") String productId, @PathParam("amount") Integer amount) {
        return ResponseEntity.success("hello");
    }
}
