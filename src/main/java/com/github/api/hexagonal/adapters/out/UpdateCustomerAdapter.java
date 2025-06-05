package com.github.api.hexagonal.adapters.out;

import com.github.api.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.github.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.api.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void updateCustomer(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
