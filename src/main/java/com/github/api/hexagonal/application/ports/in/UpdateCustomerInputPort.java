package com.github.api.hexagonal.application.ports.in;

import com.github.api.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface UpdateCustomerInputPort {

    void updateCustomer(Customer customer, String zipCode);
}
