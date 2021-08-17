package com.java.springbootapplication.controller;

import com.java.springbootapplication.dto.AddressDto;
import com.java.springbootapplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    public List<AddressDto> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/id")
    public AddressDto getAddressByIdWithParam(@RequestParam Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping("/id/{id}")
    public AddressDto getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping("/id/query/{id}")
    public AddressDto getAddressByIdWithQuery(@PathVariable("id") Long id) {
        return addressService.getAddressByIdWithQuery(id);
    }

    @GetMapping("/amounts")
    public Long countAddresses() {
        return addressService.countAddresses();
    }

    @GetMapping("/exists")
    public Boolean isAddressExistsByIdWithParam(@RequestParam Long id) {
        return addressService.isExistsAddressById(id);
    }

    @GetMapping("/exists/id/{id}")
    public Boolean isAddressExistsById(@PathVariable("id") Long id) {
        return addressService.isExistsAddressById(id);
    }
}
