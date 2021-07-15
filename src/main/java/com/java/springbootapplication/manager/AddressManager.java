package com.java.springbootapplication.manager;

import com.java.springbootapplication.dao.entity.Address;
import com.java.springbootapplication.dao.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressManager {

    private AddressRepository addressRepository;

    @Autowired
    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Iterable<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Long countAddresses() {
        return addressRepository.count();
    }

    public boolean isExistsAddressById(Long id) {
        return addressRepository.existsById(id);
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
