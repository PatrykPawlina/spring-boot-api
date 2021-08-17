package com.java.springbootapplication.repository;

import com.java.springbootapplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address getAddressById(Long id);

    @Query("SELECT a FROM Address a WHERE a.id LIKE :id")
    Address getAddressByIdWithQuery(Long id);

    Boolean existsAddressById(Long id);
}
