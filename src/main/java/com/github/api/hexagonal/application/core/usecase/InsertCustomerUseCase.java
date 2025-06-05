package com.github.api.hexagonal.application.core.usecase;

import com.github.api.hexagonal.adapters.out.client.response.AddressResponse;
import com.github.api.hexagonal.application.core.domain.Address;
import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.github.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.github.api.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.github.api.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var adress = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAdress(adress);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.sendCpf(customer.getCpf());
    }
}
