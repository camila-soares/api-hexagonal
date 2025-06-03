package com.github.api.hexagonal.adapters.out.client.response;


import lombok.Data;

@Data
public class AddressResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String uf;
}
