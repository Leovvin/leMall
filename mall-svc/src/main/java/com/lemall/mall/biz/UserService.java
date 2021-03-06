package com.lemall.mall.biz;

import com.lemall.mall.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    OrderService orderService;

    @Transactional
    public Order book(long userId,long productId,long inventoryId,int amount){
        if (!inventoryService.increaseStockForUpdate(inventoryId,amount)){
            return null;
        }

        return orderService.createOrder(userId,productId,amount);
    }
}
