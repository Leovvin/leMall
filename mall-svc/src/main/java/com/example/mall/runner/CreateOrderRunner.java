package com.example.mall.runner;

import com.example.mall.biz.UserService;
import com.example.mall.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "createOrder")
public class CreateOrderRunner implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Override
    public void run(String... args) throws Exception {
        Order order = userService.book(1,1,1,1);
        order.getAmount();
    }
}
