package com.github.api.hexagonal.application.ports.out;

import com.github.api.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);


}
