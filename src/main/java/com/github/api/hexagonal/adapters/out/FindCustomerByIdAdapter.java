package com.github.api.hexagonal.adapters.out;

import com.github.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.api.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.github.api.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Optional<Customer> findById(String id) {
       var customerEntity = customerRepository.findById(id);
        return customerEntity
                .map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
