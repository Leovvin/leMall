package com.lemall.mall.biz;

import com.lemall.mall.model.Product;
import com.lemall.mall.dao.OrderMapper;
import com.lemall.mall.model.Order;
import com.lemall.mall.model.User;
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
