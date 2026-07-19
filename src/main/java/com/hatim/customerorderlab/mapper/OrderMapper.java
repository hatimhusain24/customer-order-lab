package com.hatim.customerorderlab.mapper;


import com.hatim.customerorderlab.dto.OrderDto;
import com.hatim.customerorderlab.entity.Order;

public class OrderMapper {
    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .amount(order.getAmount())
                .status(order.getStatus())
                .orderDate(order.getOrderDate())
                .customerId(order.getCustomer().getId())
                .build();
    }
}
