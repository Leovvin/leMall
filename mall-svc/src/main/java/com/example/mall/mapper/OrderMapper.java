package com.example.mall.mapper;

import com.example.mall.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    Order create(Order example);
}
