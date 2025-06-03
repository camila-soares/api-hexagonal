package com.github.api.hexagonal.application.core.domain;

public class Customer {
    public Customer() {
        this.isValidcpf = false;
    }

    public Customer(String id, String name, Address adress, String cpf, Boolean isValidcpf) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.cpf = cpf;
        this.isValidcpf = isValidcpf;
    }
    private String id;
    private String name;
    private Address adress;
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

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
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
