package com.github.api.hexagonal.adapters.in.controller.mapper;


import com.github.api.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.github.api.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.github.api.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "adress", ignore = true)
    @Mapping(target = "validcpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
