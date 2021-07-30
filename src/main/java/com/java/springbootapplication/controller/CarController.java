package com.java.springbootapplication.controller;

import com.java.springbootapplication.dto.CarDto;
import com.java.springbootapplication.entity.Car;
import com.java.springbootapplication.entity.User;
import com.java.springbootapplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/id")
    public CarDto getCarByIdWithParam(@RequestParam Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/id/{id}")
    public CarDto getCarById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/brands")
    public List<CarDto> getCarsByBrandWithParam(@RequestParam String brand) {
        return carService.findCarsByBrand(brand);
    }

    @GetMapping("/brands/{brand}")
    public List<CarDto> findCarsByBrand(@PathVariable("brand") String brand) {
        return carService.findCarsByBrand(brand);
    }

    @GetMapping("/brands/query/like")
    public List<CarDto> getCarsByBrandWithQueryLike(String brand) {
        return carService.getCarsByBrandWithQueryLike(brand);
    }

    @GetMapping("/brands/query")
    public List<CarDto> getCarsByBrandWithQuery(@RequestParam String brand) {
        return carService.getCarsByBrandWithQuery(brand);
    }

    @GetMapping("/models")
    public List<CarDto> getCarsByModelWithParam(@RequestParam String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/models/{model}")
    public List<CarDto> findCarsByModel(@PathVariable("model") String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/models/query/like")
    public List<Car> findCarsByModelWithQueryLike(String model) {
        return carService.findCarsByModelWithQueryLike(model);
    }

    @GetMapping("/models/query")
    public List<Car> findCarsByModelWithQuery(@RequestParam String model) {
        return carService.findCarsByModelWithQuery(model);
    }

    @GetMapping("/year")
    public List<Car> findCarsByYearWithParam(@RequestParam Integer year) {
        return carService.findCarsByYear(year);
    }

    @GetMapping("/year/query")
    public List<Car> findCarsByYearWithParamWithQuery(Integer year) {
        return carService.findCarsByYearWithQuery(year);
    }

    @GetMapping("/year/{year}")
    public List<Car> findCarsByYear(@PathVariable("year") Integer year) {
        return carService.findCarsByYear(year);
    }

    @GetMapping("/params")
    public List<Car> findCardByBrandModelOrYear(@RequestParam(required = false) String brand,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) Integer year) {
        return carService.findCarsByBrandOrModelOrYear(brand, model, year);
    }

    @GetMapping("/params/pagination")
    public Page<Car> findCardByBrandModelOrYearWithPagination(@RequestParam(required = false) String brand,
                                                              @RequestParam(required = false) String model,
                                                              @RequestParam(required = false) Integer year,
                                                              @RequestParam int pageNumber,
                                                              @RequestParam int pageSize) {
        return carService.findCarsByBrandOrModelOrYearWithPagination(brand, model, year, pageNumber, pageSize);
    }

    @GetMapping("/params/query/pagination")
    public Page<Car> findCardByBrandModelOrYearWithQueryAndPagination(@RequestParam(required = false) String brand,
                                                                      @RequestParam(required = false) String model,
                                                                      @RequestParam(required = false) Integer year,
                                                                      @RequestParam int pageNumber,
                                                                      @RequestParam int pageSize) {
        return carService.findCarsByBrandOrModelOrYearWithQueryAndPagination(brand, model, year, pageNumber, pageSize);
    }

    @GetMapping("/params/query")
    public List<Car> findCardByBrandModelOrYearWithQuery(@RequestParam(required = false) String brand,
                                                         @RequestParam(required = false) String model,
                                                         @RequestParam(required = false) Integer year) {
        return carService.findCarsByBrandOrModelOrYearWithQuery(brand, model, year);
    }

    @GetMapping("/users")
    public List<Car> findCarsWithUsers(User user) {
        return carService.findCarsWithUsers(user);
    }

    @GetMapping("/amounts")
    public Long countCars() {
        return carService.countCars();
    }

    @GetMapping("/amounts/brands")
    public Long countCarsByBrandWithParam(@RequestParam String brand) {
        return carService.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/brands/query")
    public Long countCarsByBrandWithParamWithQuery(@RequestParam String brand) {
        return carService.countCarsByBrandWithQuery(brand);
    }

    @GetMapping("/amounts/brands/{brand}")
    public Long countCarsByBrand(@PathVariable("brand") String brand) {
        return carService.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/models")
    public Long countCarsByModelWithParam(@RequestParam String model) {
        return carService.countCarsByModel(model);
    }

    @GetMapping("/amounts/models/query")
    public Long countCarsByModelWithParamWithQuery(@RequestParam String model) {
        return carService.countCarsByModelWithQuery(model);
    }

    @GetMapping("/amounts/models/{model}")
    public Long countCarsByModel(@PathVariable("model") String model) {
        return carService.countCarsByModel(model);
    }

    @GetMapping("/amounts/year")
    public Long countCarsByYearWithParam(@RequestParam Integer year) {
        return carService.countCarsByYear(year);
    }

    @GetMapping("/amounts/year/query")
    public Long countCarsByYearWithParamWithQuery(@RequestParam Integer year) {
        return carService.countCarsByYearWithQuery(year);
    }

    @GetMapping("/amounts/year/{year}")
    public Long countCarsByYear(@PathVariable("year") Integer year) {
        return carService.countCarsByYear(year);
    }

    @GetMapping("/exists")
    public Boolean isCarExistsByIdWithParam(@RequestParam Long index) {
        return carService.isCarExistsById(index);
    }

    @GetMapping("/exists/index/{index}")
    public Boolean isCarExistsById(@PathVariable("index") Long index) {
        return carService.isCarExistsById(index);
    }

    @GetMapping("/exists/brands")
    public Boolean isCarExistsByBrandWithParam(@RequestParam String brand) {
        return carService.isCarExistsByBrand(brand);
    }

    @GetMapping("/exists/brands/query")
    public Boolean isCarExistsByBrandWithParamWithQuery(@RequestParam String brand) {
        return carService.isCarExistsByBrandWithQuery(brand);
    }

    @GetMapping("/exists/brands/{brand}")
    public Boolean isCarExistsByBrand(@PathVariable("brand") String brand) {
        return carService.isCarExistsByBrand(brand);
    }

    @GetMapping("/exists/models")
    public Boolean isCarExistsByModelWithParam(@RequestParam String model) {
        return carService.isCarExistsByModel(model);
    }

    @GetMapping("/exists/models/query")
    public Boolean isCarExistsByModelWithParamWithQuery(@RequestParam String model) {
        return carService.isCarExistsByModelWithQuery(model);
    }

    @GetMapping("/exists/models/{model}")
    public Boolean isCarExistsByModel(@PathVariable("model") String model) {
        return carService.isCarExistsByModel(model);
    }

    @GetMapping("/exists/year")
    public Boolean isCarExistsByYearWithParam(@RequestParam Integer year) {
        return carService.isCarExistsByYear(year);
    }

    @GetMapping("/exists/year/query")
    public Boolean isCarExistsByYearWithParamWithQuery(@RequestParam Integer year) {
        return carService.isCarExistsByYearWithQuery(year);
    }

    @GetMapping("/exists/year/{year}")
    public Boolean isCarExistsByYear(@PathVariable("year") Integer year) {
        return carService.isCarExistsByYear(year);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping
    public void deleteCarById(@RequestParam Long index) {
        carService.deleteCarById(index);
    }

    @DeleteMapping("/id/{index}")
    public void deleteCarByID(@PathVariable("index") Long index) {
        carService.deleteCarById(index);
    }

    @DeleteMapping("/clear")
    public void deleteCars() {
        carService.deleteAllCars();
    }
}