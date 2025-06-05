package com.github.api.hexagonal.adapters.in.consumer;


import com.github.api.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.github.api.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.api.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private CustomerMessageMapper customerMessageMapper;


    @KafkaListener(topics = "tp-cpf-validated", groupId = "camila")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.updateCustomer(customer, customerMessage.getZipCode());
    }
}
