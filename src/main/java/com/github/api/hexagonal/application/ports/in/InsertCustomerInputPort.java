package com.github.api.hexagonal.application.ports.in;

import com.github.api.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.github.api.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerInputPort {

    void insert(Customer customer, String cep);
}
