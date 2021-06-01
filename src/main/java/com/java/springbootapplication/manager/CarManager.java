package com.java.springbootapplication.manager;

import com.java.springbootapplication.dao.entity.Car;
import com.java.springbootapplication.dao.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManager {

    private CarRepo carRepo;

    @Autowired
    public CarManager(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Iterable<Car> findAllCars() {
        return carRepo.findAll();
    }

    public Optional<Car> findCarById(Long id) {
        return carRepo.findById(id);
    }

    public List<Car> findCarsByBrand(String brand) {
        return carRepo.findCarsByBrand(brand);
    }

    public List<Car> findCarsByModel(String model) {
        return carRepo.findCarsByModel(model);
    }

    public List<Car> findCarsByAge(Integer age) {
        return carRepo.findCarsByAge(age);
    }

    public List<Car> findCarsByBrandOrModelOrAge(String brand, String model, Integer age) {
        return carRepo.findCarsByBrandOrModelOrAge(brand, model, age);
    }

    public Long countCars() {
        return carRepo.count();
    }

    public Long countCarsByBrand(String brand) {
        return carRepo.countCarByBrand(brand);
    }

    public Long countCarsByModel(String model) {
        return carRepo.countCarByModel(model);
    }

    public Long countCarsByAge(Integer age) {
        return carRepo.countCarByAge(age);
    }

    public Boolean isCarExistsById(Long id) {
        return carRepo.existsById(id);
    }

    public Boolean isCarExistsByBrand(String brand) {
        return carRepo.existsCarByBrand(brand);
    }

    public Boolean isCarExistsByModel(String model) {
        return carRepo.existsCarByModel(model);
    }

    public Boolean isCarExistsByAge(Integer age) {
        return carRepo.existsCarByAge(age);
    }

    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    public void deleteCarById(Long id) {
        carRepo.deleteById(id);
    }

    public void deleteAll() {
        carRepo.deleteAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        saveCar(new Car(1L, "Nissan", "Juke", 1));
        saveCar(new Car(2L, "Mazda", "CX30", 3));
        saveCar(new Car(3L, "Toyota", "Yaris", 5));
        saveCar(new Car(4L, "Suzuki", "Swift", 7));
    }
}