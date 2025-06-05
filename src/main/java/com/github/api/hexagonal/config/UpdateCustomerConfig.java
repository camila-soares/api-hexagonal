package com.github.api.hexagonal.config;


import com.github.api.hexagonal.adapters.out.FindAddressAdapterZipcode;
import com.github.api.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.github.api.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.github.api.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdAdapter,
                                                       FindAddressAdapterZipcode findAddressAdapterZipcode, UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdAdapter,
                findAddressAdapterZipcode, updateCustomerAdapter);
    }
}
