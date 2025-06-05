package com.github.api.hexagonal.config;


import com.github.api.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.github.api.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.github.api.hexagonal.adapters.out.repository.CustomerRepository;
import com.github.api.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.github.api.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {


    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerAdapter deleteCustomerAdapter) {

        return new DeleteCustomerUseCase(findCustomerByIdUseCase, deleteCustomerAdapter);
    }
}
