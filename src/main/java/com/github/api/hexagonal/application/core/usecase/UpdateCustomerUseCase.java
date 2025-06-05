package com.github.api.hexagonal.application.core.usecase;

import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.api.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.github.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.github.api.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;

    }


    @Override
    public void updateCustomer(Customer customer, String zipCode) {
        findCustomerByIdInputPort.findById(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAdress(address);
        updateCustomerOutputPort.updateCustomer(customer);
    }
}
