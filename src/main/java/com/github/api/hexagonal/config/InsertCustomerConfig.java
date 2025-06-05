package com.github.api.hexagonal.config;


import com.github.api.hexagonal.adapters.out.FindAddressAdapterZipcode;
import com.github.api.hexagonal.adapters.out.InsertCustomerAdapter;
import com.github.api.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.github.api.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressAdapterZipcode findAddressAdapterZipcode,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter) {

        return new InsertCustomerUseCase(findAddressAdapterZipcode, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
