package com.github.api.hexagonal.application.ports.in;

import com.github.api.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
