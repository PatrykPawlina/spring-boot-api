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

    @GetMapping("/id")
    public Optional<Car> getCarByIdWithParam(@RequestParam Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("/id/{index}")
    public Optional<Car> getCarById(@PathVariable("index") Long index) {
        return carManager.findCarById(index);
    }

    @GetMapping("/brands")
    public List<Car> findCarsByBrandWithParam(@RequestParam String brand) {
        return carManager.findCarsByBrand(brand);
    }

    @GetMapping("/brands/{brand}")
    public List<Car> findCarsByBrand(@PathVariable("brand") String brand) {
        return carManager.findCarsByBrand(brand);
    }

    @GetMapping("/models")
    public List<Car> findCarsByModelWithParam(@RequestParam String model) {
        return carManager.findCarsByModel(model);
    }

    @GetMapping("/models/{model}")
    public List<Car> findCarsByModel(@PathVariable("model") String model) {
        return carManager.findCarsByModel(model);
    }

    @GetMapping("/age")
    public List<Car> findCarsByAgeWithParam(@RequestParam Integer age) {
        return carManager.findCarsByAge(age);
    }

    @GetMapping("/age/{age}")
    public List<Car> findCarsByAge(@PathVariable("age") Integer age) {
        return carManager.findCarsByAge(age);
    }

    @GetMapping("/params")
    public List<Car> findCardByBrandModelOrAge(@RequestParam(required = false) String brand,
                                               @RequestParam(required = false) String model,
                                               @RequestParam(required = false) Integer age) {
        return carManager.findCarsByBrandOrModelOrAge(brand, model, age);
    }

    @GetMapping("/amounts")
    public Long countCars() {
        return carManager.countCars();
    }

    @GetMapping("/amounts/brands")
    public Long countCarsByBrandWithParam(@RequestParam String brand) {
        return carManager.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/brands/{brand}")
    public Long countCarsByBrand(@PathVariable("brand") String brand) {
        return carManager.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/models")
    public Long countCarsByModelWithParam(@RequestParam String model) {
        return carManager.countCarsByModel(model);
    }

    @GetMapping("/amounts/models/{model}")
    public Long countCarsByModel(@PathVariable("model") String model) {
        return carManager.countCarsByModel(model);
    }

    @GetMapping("/amounts/age")
    public Long countCarsByAgeWithParam(@RequestParam Integer age) {
        return carManager.countCarsByAge(age);
    }

    @GetMapping("/amounts/age/{age}")
    public Long countCarsByAge(@PathVariable("age") Integer age) {
        return carManager.countCarsByAge(age);
    }

    @GetMapping("/exists")
    public Boolean isCarExistsByIdWithParam(@RequestParam Long index) {
        return carManager.isCarExistsById(index);
    }

    @GetMapping("/exists/index/{index}")
    public Boolean isCarExistsById(@PathVariable("index") Long index) {
        return carManager.isCarExistsById(index);
    }

    @GetMapping("/exists/brands")
    public Boolean isCarExistsByBrandWithParam(@RequestParam String brand) {
        return carManager.isCarExistsByBrand(brand);
    }

    @GetMapping("/exists/brands/{brand}")
    public Boolean isCarExistsByBrand(@PathVariable("brand") String brand) {
        return carManager.isCarExistsByBrand(brand);
    }

    @GetMapping("/exists/models")
    public Boolean isCarExistsByModelWithParam(@RequestParam String model) {
        return carManager.isCarExistsByModel(model);
    }

    @GetMapping("/exists/models/{model}")
    public Boolean isCarExistsByModel(@PathVariable("model") String model) {
        return carManager.isCarExistsByModel(model);
    }

    @GetMapping("/exists/age")
    public Boolean isCarExistsByAgeWithPara(@RequestParam Integer age) {
        return carManager.isCarExistsByAge(age);
    }

    @GetMapping("/exists/age/{age}")
    public Boolean isCarExistsByAge(@PathVariable("age") Integer age) {
        return carManager.isCarExistsByAge(age);
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