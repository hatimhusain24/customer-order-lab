package com.hatim.customerorderlab.service.impl;

import com.hatim.customerorderlab.dto.OrderDto;
import com.hatim.customerorderlab.entity.Customer;
import com.hatim.customerorderlab.entity.Order;
import com.hatim.customerorderlab.exception.ResourceNotFoundException;
import com.hatim.customerorderlab.mapper.OrderMapper;
import com.hatim.customerorderlab.repository.CustomerRepository;
import com.hatim.customerorderlab.repository.OrderRepository;
import com.hatim.customerorderlab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id: " + dto.getCustomerId()));

        Order order = Order.builder()
                .orderNumber(dto.getOrderNumber())
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .orderDate(dto.getOrderDate())
                .customer(customer)
                .build();

        Order createOrder = orderRepository.save(order);
        return OrderMapper.toDto(createOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return List.of();
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto dto) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }
}
