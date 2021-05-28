package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.Car;
import com.java.springbootapplication.manager.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
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
    public Optional<Car> getCarByIdWithParam(@RequestParam Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("/id/{index}")
    public Optional<Car> getCarById(@PathVariable("index") Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("/brands")
    public List<Car> findCarsByBrandWithParam(@RequestParam String brand) {
        return carManager.findCarsByCarBrand(brand);
    }

    @GetMapping("/brands/{brand}")
    public List<Car> findCarsByBrand(@PathVariable("brand") String carBrand) {
        return carManager.findCarsByCarBrand(carBrand);
    }

    @GetMapping("/models")
    public List<Car> findCarsByModelWithParam(@RequestParam String model) {
        return carManager.findCarsByModel(model);
    }

    @GetMapping("/models/{model}")
    public List<Car> findCarsByModel(@PathVariable("model") String carModel) {
        return carManager.findCarsByModel(carModel);
    }

    @GetMapping("/age")
    public List<Car> findCarsByAgeWithParam(@RequestParam Integer age) {
        return carManager.findCarsByAge(age);
    }

    @GetMapping("/age/{age}")
    public List<Car> findCarsByAge(@PathVariable("age") Integer carAge) {
        return carManager.findCarsByAge(carAge);
    }

    @GetMapping("params")
    public List<Car> findCardByBrandModelOrAge(@RequestParam(required = false) String brand,
                                               @RequestParam(required = false) String model,
                                               @RequestParam(required = false) Integer age) {
        return carManager.findCarsByBrandOrModelOrAge(brand, model, age);
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

    @DeleteMapping("/clear")
    public void deleteCars() {
        carManager.deleteAll();
    }
}
