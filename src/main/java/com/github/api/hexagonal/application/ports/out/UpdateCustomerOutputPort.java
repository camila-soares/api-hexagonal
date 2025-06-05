package com.github.api.hexagonal.application.ports.out;

import com.github.api.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface UpdateCustomerOutputPort {

    void updateCustomer(Customer customer);
}
