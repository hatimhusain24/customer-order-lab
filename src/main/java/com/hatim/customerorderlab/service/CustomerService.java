package com.hatim.customerorderlab.service;

import com.hatim.customerorderlab.dto.CustomerDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customer);
    void deleteCustomer(Long id);
    CustomerDto getCustomerByEmail(String email);
    Page<CustomerDto> getCustomers(int page, int size);
    List<CustomerDto> sortCustomers(String field);
}
