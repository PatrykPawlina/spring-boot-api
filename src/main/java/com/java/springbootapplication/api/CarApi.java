package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.Car;
import com.java.springbootapplication.manager.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping("/all")
    public Iterable<Car> getAllCars() {
        return carManager.findAllCars();
    }

    @GetMapping
    public Optional<Car> getCarById(@RequestParam Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("id/{index}")
    public Optional<Car> getCarByID(@PathVariable("index") Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("/amount")
    public Long countCars() {
        return carManager.countCars();
    }

    @GetMapping("/exists/{index}")
    public Boolean isCarExists(@PathVariable("index") Long index) {
        return carManager.isCarExists(index);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carManager.saveCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carManager.saveCar(car);
    }

    @DeleteMapping
    public void deleteCarById(@RequestParam Long index) {
        carManager.deleteCarById(index);
    }

    @DeleteMapping("/id/{index}")
    public void deleteCarByID(@PathVariable("index") Long index) {
        carManager.deleteCarById(index);
    }

    @DeleteMapping("clear")
    public void deleteCars() {
        carManager.deleteAll();
    }
}
