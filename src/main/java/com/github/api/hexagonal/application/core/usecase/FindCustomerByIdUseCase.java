package com.github.api.hexagonal.application.core.usecase;

import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.api.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer findById(String id) {
        return findCustomerByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
