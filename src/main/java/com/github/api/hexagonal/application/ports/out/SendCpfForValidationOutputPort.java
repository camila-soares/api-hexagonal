package com.github.api.hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {

    void sendCpf(String cpf);
}
