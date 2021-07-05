package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.Owner;
import com.java.springbootapplication.manager.OwnerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/owners")
public class OwnerApi {

    private OwnerManager ownerManager;

    @Autowired
    public OwnerApi(OwnerManager ownerManager) {
        this.ownerManager = ownerManager;
    }

    @GetMapping("/all")
    public Iterable<Owner> findAll() {
        return ownerManager.findAllOwners();
    }

    @GetMapping("id")
    public Optional<Owner> findAllOwnersByIdWithParam(@RequestParam Long id) {
        return ownerManager.findOwnersById(id);
    }

}
