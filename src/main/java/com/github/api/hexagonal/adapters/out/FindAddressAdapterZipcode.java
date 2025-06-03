package com.github.api.hexagonal.adapters.out;

import com.github.api.hexagonal.adapters.out.client.FindAddressZipcodeClient;
import com.github.api.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.github.api.hexagonal.application.core.domain.Address;
import com.github.api.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressAdapterZipcode implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressZipcodeClient findAddressZipcodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String cep) {
        var addressResponse = findAddressZipcodeClient.find(cep);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
