package com.lemall.mall.dao;

import com.lemall.mall.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int create(Order example);
}
