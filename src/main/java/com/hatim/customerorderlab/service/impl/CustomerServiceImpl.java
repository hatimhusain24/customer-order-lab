package com.hatim.customerorderlab.service.impl;

import com.hatim.customerorderlab.dto.CustomerDto;
import com.hatim.customerorderlab.entity.Customer;
import com.hatim.customerorderlab.exception.ResourceNotFoundException;
import com.hatim.customerorderlab.mapper.CustomerMapper;
import com.hatim.customerorderlab.repository.CustomerRepository;
import com.hatim.customerorderlab.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer saveCustomer = customerRepository.save(customer);
        return CustomerMapper.toDto(saveCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id " + id));
        return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id " + id));

            existingCustomer.setFirstName(customerDto.getFirstName());
            existingCustomer.setLastName(customerDto.getLastName());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setPhone(customerDto.getPhone());

            Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.toDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                        .orElseThrow(() ->
                                new  ResourceNotFoundException("Customer not found with id " + id));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with email " + email));
        return CustomerMapper.toDto(customer);
    }
}
