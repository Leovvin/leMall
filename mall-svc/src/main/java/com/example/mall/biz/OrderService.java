package com.example.mall.biz;

import com.example.mall.mapper.OrderMapper;
import com.example.mall.model.Order;
import com.example.mall.model.Product;
import com.example.mall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Transactional
    public Order createOrder(long userId,long productId,int amount){
        Order order = new Order();
        User user = new User();
        user.setId(userId);
        order.setUser(user);
        Product product = new Product();
        product.setId(productId);
        order.setProduct(product);
        order.setAmount(amount);
        orderMapper.create(order);
        return order;
    }
}
