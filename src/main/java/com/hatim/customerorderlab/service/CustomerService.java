package com.hatim.customerorderlab.service;

import com.hatim.customerorderlab.dto.CustomerDto;
import com.hatim.customerorderlab.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customer);
    void deleteCustomer(Long id);
}
