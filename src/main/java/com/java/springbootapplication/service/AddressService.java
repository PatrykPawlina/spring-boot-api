package com.java.springbootapplication.service;

import com.java.springbootapplication.dto.AddressDto;
import com.java.springbootapplication.entity.Address;
import com.java.springbootapplication.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private ConverterService converterService;

    @Autowired
    public AddressService(AddressRepository addressRepository, ConverterService converterService) {
        this.addressRepository = addressRepository;
        this.converterService = converterService;
    }

    public List<AddressDto> getAllAddresses() {
        List<Address> addressDataList = addressRepository.findAll();
        return addressDataList.stream().map(converterService::convertAddressToDto).collect(Collectors.toList());
    }

    public AddressDto getAddressById(Long id) {
        Address addressObject = addressRepository.getAddressById(id);
        return converterService.convertAddressToDto(addressObject);
    }

    public AddressDto getAddressByIdWithQuery(Long id) {
        Address addressObject = addressRepository.getAddressByIdWithQuery(id);
        return converterService.convertAddressToDto(addressObject);
    }

    public Long countAddresses() {
        return addressRepository.count();
    }

    public Boolean isExistsAddressById(Long id) {
        return addressRepository.existsAddressById(id);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }
}
