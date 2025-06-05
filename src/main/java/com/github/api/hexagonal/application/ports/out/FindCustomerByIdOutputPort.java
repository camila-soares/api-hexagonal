package com.github.api.hexagonal.application.ports.out;

import com.github.api.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);
}
