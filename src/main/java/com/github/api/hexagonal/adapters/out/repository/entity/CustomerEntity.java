package com.github.api.hexagonal.adapters.out.repository.entity;

import com.github.api.hexagonal.application.core.domain.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity adress;
    private String cpf;
    private Boolean isValidcpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEntity getAdress() {
        return adress;
    }

    public void setAdress(AddressEntity adress) {
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
