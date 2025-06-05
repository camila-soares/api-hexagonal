package com.github.api.hexagonal.adapters.in.controller;


import com.github.api.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.github.api.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.github.api.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.github.api.hexagonal.application.core.domain.Customer;
import com.github.api.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.github.api.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.api.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.github.api.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.created(URI.create(customer.getCpf())).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.findById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.updateCustomer(customer, customerRequest.getZipCode());

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerInputPort.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
