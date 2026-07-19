package com.hatim.customerorderlab.service;

import com.hatim.customerorderlab.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    List<OrderDto> getAllOrders();
    OrderDto updateOrder(Long id, OrderDto dto);
    void deleteOrder(Long id);
}
