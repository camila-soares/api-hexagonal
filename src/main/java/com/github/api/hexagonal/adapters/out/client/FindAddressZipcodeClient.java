package com.github.api.hexagonal.adapters.out.client;


import com.github.api.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressZipcodeClient",
            url = "${find.client.address.url}")
public interface FindAddressZipcodeClient {

    @GetMapping("{cep}/json/")
    AddressResponse find(@PathVariable("cep") String cep);
}
