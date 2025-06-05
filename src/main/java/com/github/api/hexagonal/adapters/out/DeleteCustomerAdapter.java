package com.github.api.hexagonal.adapters.out;


import com.github.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.api.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
