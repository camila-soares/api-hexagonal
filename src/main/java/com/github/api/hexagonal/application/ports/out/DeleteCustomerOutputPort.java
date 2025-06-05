package com.github.api.hexagonal.application.ports.out;


import org.springframework.stereotype.Component;

@Component
public interface DeleteCustomerOutputPort {

    void deleteCustomer(String customerId);
}
