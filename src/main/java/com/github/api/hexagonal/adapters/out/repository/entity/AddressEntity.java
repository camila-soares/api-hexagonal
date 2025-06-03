package com.github.api.hexagonal.adapters.out.repository.entity;


import lombok.Data;

@Data
public class AddressEntity {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String uf;
}
