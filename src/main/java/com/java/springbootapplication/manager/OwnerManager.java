package com.java.springbootapplication.manager;

import com.java.springbootapplication.dao.entity.Owner;
import com.java.springbootapplication.dao.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerManager {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerManager(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Iterable<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findOwnersById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {

//        saveOwner(new Owner(2L, Gender.FEMALE, "Katarzyna", "Grudzień",
//                new Car(2L, "Mazda", "CX30", 3)));
//
//        saveOwner(new Owner(3L, Gender.MALE, "Daniel", "Nowakowski",
//                new Car(3L, "Toyota", "Yaris", 5)));
//
//        saveOwner(new Owner(4L, Gender.MALE, "Krzysztof", "Kowalski",
//                new Car(4L, "Suzuki", "Swift", 7)));
//
//        saveOwner(new Owner(5L, Gender.MALE, "Marek", "Bieniek",
//                new Car(5L, "Volvo", "XC90", 12)));
//
//        saveOwner(new Owner(6L, Gender.MALE, "Adam", "Smoliński",
//                new Car(6L, "BMW", "M3", 9)));
//
//        saveOwner(new Owner(7L, Gender.MALE, "Janusz", "Szpakowsi",
//                new Car(7L, "Subaru", "Forester", 8)));
//
//        saveOwner(new Owner(8L, Gender.FEMALE, "Dorota", "Kubiela",
//                new Car(8L, "Peugeot", "2008", 4)));
//
//        saveOwner(new Owner(9L, Gender.FEMALE, "Izabela", "Gąbka",
//                new Car(9L, "Nissan", "GTR", 7)));
//
//        saveOwner(new Owner(10L, Gender.FEMALE, "Karolina", "Jakubowska",
//                new Car(10L, "Mazda", "6", 3)));
//
//        saveOwner(new Owner(11L, Gender.FEMALE, "Aneta", "Molenda",
//                new Car(11L, "Toyota", "Corolla", 5)));
//
//        saveOwner(new Owner(12L, Gender.MALE, "Sławomir", "Janiga",
//                new Car(12L, "Renault", "Cactus", 7)));
//
//        saveOwner(new Owner(13L, Gender.FEMALE, "Aleksandra", "Pawenta",
//                new Car(13L, "Volvo", "V40", 12)));
//
//        saveOwner(new Owner(14L, Gender.MALE, "Jakub", "Zalewski",
//                new Car(14L, "Mazda", "6", 3)));
//
//        saveOwner(new Owner(15L, Gender.MALE, "Marcin", "Najman",
//                new Car(15L, "Subaru", "Impreza", 9)));
//
//        saveOwner(new Owner(16L, Gender.FEMALE, "Agata", "Zięba",
//                new Car(16L, "Peugeot", "508", 4)));
//
//        saveOwner(new Owner(17L, Gender.MALE, "Norbert", "Drzewiecki",
//                new Car(17L, "Nissan", "Nismo", 1)));
//
//        saveOwner(new Owner(18L, Gender.FEMALE, "Paulina", "Dąbrowska",
//                new Car(18L, "Honda", "Civic", 3)));
//
//        saveOwner(new Owner(19L, Gender.MALE, "Błażej", "Talski",
//                new Car(19L, "Toyota", "CRV", 6)));
//
//        saveOwner(new Owner(20L, Gender.FEMALE, "Zuzanna", "Ostrowska",
//                new Car(20L, "Renault", "Clio Sport", 7)));
//
//        saveOwner(new Owner(21L, Gender.MALE, "Adrian", "Lipiński",
//                new Car(21L, "Opel", "Astra", 12)));
//
//        saveOwner(new Owner(22L, Gender.FEMALE, "Dagmara", "Leśmian",
//                new Car(22L, "Seat", "Leon", 9)));
//
//        saveOwner(new Owner(23L, Gender.MALE, "Przemek", "Szymański",
//                new Car(23L, "Fiat", "Tipo", 6)));
//
//        saveOwner(new Owner(24L, Gender.FEMALE, "Anna", "Polna",
//                new Car(24L, "Peugeot", "308", 4)));
  }
}


