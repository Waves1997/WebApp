package com.example.webapp.service;

import com.example.webapp.domain.Address;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    void testDelete() {
        addressService.removeById(1);
    }

    @Test
    void testQuery() {
        Address address = addressService.getById(1);
        System.out.println(address);
    }
}