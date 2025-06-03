package com.github.api.hexagonal.adapters.out.client.mapper;


import com.github.api.hexagonal.adapters.out.client.response.AddressResponse;
import com.github.api.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
