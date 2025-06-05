package com.github.api.hexagonal.adapters.in.controller.response;
import lombok.Data;


@Data
public class CustomerResponse {

    private String name;
    private AddressResponse adress;
    private String cpf;
    private Boolean isValidcpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressResponse getAdress() {
        return adress;
    }

    public void setAdress(AddressResponse adress) {
        this.adress = adress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidcpf() {
        return isValidcpf;
    }

    public void setValidcpf(Boolean validcpf) {
        isValidcpf = validcpf;
    }
}
