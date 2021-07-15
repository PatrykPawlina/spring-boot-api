package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.Address;
import com.java.springbootapplication.manager.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/addresses")
public class AddressApi {

    private AddressManager addressManager;

    @Autowired
    public AddressApi(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @GetMapping("/all")
    public Iterable<Address> getAllAddresses() {
        return addressManager.findAllAddresses();
    }

    @GetMapping("/id")
    public Optional<Address> getAddressByIdWithParam(@RequestParam Long id) {
        return addressManager.findAddressById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<Address> getCarById(@PathVariable("id") Long id) {
        return addressManager.findAddressById(id);
    }

    @GetMapping("/amounts")
    public Long countAddresses() {
        return addressManager.countAddresses();
    }
}
