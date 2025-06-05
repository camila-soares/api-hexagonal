package com.github.api.hexagonal.application.ports.out;

import com.github.api.hexagonal.application.core.domain.Address;


public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
