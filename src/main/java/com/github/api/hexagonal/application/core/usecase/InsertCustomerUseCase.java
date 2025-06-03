package com.github.api.hexagonal.application.core.usecase;

import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.github.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.github.api.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String cep) {
        var address = findAddressByZipCodeOutputPort.find(cep);
        customer.setAdress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
