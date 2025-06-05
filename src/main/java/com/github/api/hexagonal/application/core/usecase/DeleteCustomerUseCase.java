package com.github.api.hexagonal.application.core.usecase;

import com.github.api.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.api.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.github.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.api.hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerOutputPort deleteCustomerOutputPort;


    public DeleteCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void deleteCustomer(String customerId){
        findCustomerByIdInputPort.findById(customerId);
        deleteCustomerOutputPort.deleteCustomer(customerId);
    }
}
