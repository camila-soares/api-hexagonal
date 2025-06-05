package com.github.api.hexagonal.adapters.out;

import com.github.api.hexagonal.adapters.out.client.FindAddressZipcodeClient;
import com.github.api.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.github.api.hexagonal.adapters.out.client.response.AddressResponse;
import com.github.api.hexagonal.application.core.domain.Address;
import com.github.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressAdapterZipcode implements FindAddressByZipCodeOutputPort {

    @Autowired
    private  FindAddressZipcodeClient findAddressZipcodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    public FindAddressAdapterZipcode(FindAddressZipcodeClient findAddressZipcodeClient) {
        this.findAddressZipcodeClient = findAddressZipcodeClient;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressZipcodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
