package com.github.api.hexagonal.application.ports.in;


import org.springframework.stereotype.Component;

@Component
public interface DeleteCustomerInputPort {

    void deleteCustomer(String customerId);
}
