package com.java.springbootapplication.api;

import com.java.springbootapplication.entity.Address;
import com.java.springbootapplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/addresses")
public class AddressApi {

    private AddressService addressService;

    @Autowired
    public AddressApi(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public Iterable<Address> getAllAddresses() {
        return addressService.findAllAddresses();
    }

    @GetMapping("/id")
    public Optional<Address> getAddressByIdWithParam(@RequestParam Long id) {
        return addressService.findAddressById(id);
    }

    @GetMapping("/id/{id}")
    public Optional<Address> getCarById(@PathVariable("id") Long id) {
        return addressService.findAddressById(id);
    }

    @GetMapping("/amounts")
    public Long countAddresses() {
        return addressService.countAddresses();
    }
}
