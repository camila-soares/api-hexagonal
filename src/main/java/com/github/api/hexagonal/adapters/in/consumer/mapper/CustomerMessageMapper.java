package com.github.api.hexagonal.adapters.in.consumer.mapper;


import com.github.api.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.api.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {


    @Mapping(target = "adress", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
