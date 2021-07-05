package com.java.springbootapplication.api;

import com.java.springbootapplication.dao.entity.Car;
import com.java.springbootapplication.manager.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/brands/query/like")
    public List<Car> findCarsByBrandWithQueryLike(String brand) {
        return carManager.findCarsByBrandWithQueryLike(brand);
    }

    @GetMapping("/brands/query")
    public List<Car> findCarsByBrandWithQuery(@RequestParam String brand) {
        return carManager.findCarsByBrandWithQuery(brand);
    }

    @GetMapping("/models")
    public List<Car> findCarsByModelWithParam(@RequestParam String model) {
        return carManager.findCarsByModel(model);
    }

    @GetMapping("/models/{model}")
    public List<Car> findCarsByModel(@PathVariable("model") String model) {
        return carManager.findCarsByModel(model);
    }

    @GetMapping("/models/query/like")
    public List<Car> findCarsByModelWithQueryLike(String model) {
        return carManager.findCarsByModelWithQueryLike(model);
    }

    @GetMapping("/models/query")
    public List<Car> findCarsByModelWithQuery(@RequestParam String model) {
        return carManager.findCarsByModelWithQuery(model);
    }

    @GetMapping("/year")
    public List<Car> findCarsByYearWithParam(@RequestParam Integer year) {
        return carManager.findCarsByYear(year);
    }

    @GetMapping("/year/query")
    public List<Car> findCarsByYearWithParamWithQuery(Integer year) {
        return carManager.findCarsByYearWithQuery(year);
    }

    @GetMapping("/year/{year}")
    public List<Car> findCarsByYear(@PathVariable("year") Integer year) {
        return carManager.findCarsByYear(year);
    }

    @GetMapping("/params")
    public List<Car> findCardByBrandModelOrYear(@RequestParam(required = false) String brand,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) Integer year) {
        return carManager.findCarsByBrandOrModelOrYear(brand, model, year);
    }

    @GetMapping("/params/pagination")
    public Page<Car> findCardByBrandModelOrYearWithPagination(@RequestParam(required = false) String brand,
                                                              @RequestParam(required = false) String model,
                                                              @RequestParam(required = false) Integer year,
                                                              @RequestParam int pageNumber,
                                                              @RequestParam int pageSize) {
        return carManager.findCarsByBrandOrModelOrYearWithPagination(brand, model, year, pageNumber, pageSize);
    }

    @GetMapping("/params/query/pagination")
    public Page<Car> findCardByBrandModelOrYearWithQueryAndPagination(@RequestParam(required = false) String brand,
                                                                      @RequestParam(required = false) String model,
                                                                      @RequestParam(required = false) Integer year,
                                                                      @RequestParam int pageNumber,
                                                                      @RequestParam int pageSize) {
        return carManager.findCarsByBrandOrModelOrYearWithQueryAndPagination(brand, model, year, pageNumber, pageSize);
    }

    @GetMapping("/params/query")
    public List<Car> findCardByBrandModelOrYearWithQuery(@RequestParam(required = false) String brand,
                                                         @RequestParam(required = false) String model,
                                                         @RequestParam(required = false) Integer year) {
        return carManager.findCarsByBrandOrModelOrYearWithQuery(brand, model, year);
    }

    @GetMapping("/amounts")
    public Long countCars() {
        return carManager.countCars();
    }

    @GetMapping("/amounts/brands")
    public Long countCarsByBrandWithParam(@RequestParam String brand) {
        return carManager.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/brands/query")
    public Long countCarsByBrandWithParamWithQuery(@RequestParam String brand) {
        return carManager.countCarsByBrandWithQuery(brand);
    }

    @GetMapping("/amounts/brands/{brand}")
    public Long countCarsByBrand(@PathVariable("brand") String brand) {
        return carManager.countCarsByBrand(brand);
    }

    @GetMapping("/amounts/models")
    public Long countCarsByModelWithParam(@RequestParam String model) {
        return carManager.countCarsByModel(model);
    }

    @GetMapping("/amounts/models/query")
    public Long countCarsByModelWithParamWithQuery(@RequestParam String model) {
        return carManager.countCarsByModelWithQuery(model);
    }

    @GetMapping("/amounts/models/{model}")
    public Long countCarsByModel(@PathVariable("model") String model) {
        return carManager.countCarsByModel(model);
    }

    @GetMapping("/amounts/year")
    public Long countCarsByYearWithParam(@RequestParam Integer year) {
        return carManager.countCarsByYear(year);
    }

    @GetMapping("/amounts/year/query")
    public Long countCarsByYearWithParamWithQuery(@RequestParam Integer year) {
        return carManager.countCarsByYearWithQuery(year);
    }

    @GetMapping("/amounts/year/{year}")
    public Long countCarsByYear(@PathVariable("year") Integer year) {
        return carManager.countCarsByYear(year);
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

    @GetMapping("/exists/brands/query")
    public Boolean isCarExistsByBrandWithParamWithQuery(@RequestParam String brand) {
        return carManager.isCarExistsByBrandWithQuery(brand);
    }

    @GetMapping("/exists/brands/{brand}")
    public Boolean isCarExistsByBrand(@PathVariable("brand") String brand) {
        return carManager.isCarExistsByBrand(brand);
    }

    @GetMapping("/exists/models")
    public Boolean isCarExistsByModelWithParam(@RequestParam String model) {
        return carManager.isCarExistsByModel(model);
    }

    @GetMapping("/exists/models/query")
    public Boolean isCarExistsByModelWithParamWithQuery(@RequestParam String model) {
        return carManager.isCarExistsByModelWithQuery(model);
    }

    @GetMapping("/exists/models/{model}")
    public Boolean isCarExistsByModel(@PathVariable("model") String model) {
        return carManager.isCarExistsByModel(model);
    }

    @GetMapping("/exists/year")
    public Boolean isCarExistsByYearWithParam(@RequestParam Integer year) {
        return carManager.isCarExistsByYear(year);
    }

    @GetMapping("/exists/year/query")
    public Boolean isCarExistsByYearWithParamWithQuery(@RequestParam Integer year) {
        return carManager.isCarExistsByYearWithQuery(year);
    }

    @GetMapping("/exists/year/{year}")
    public Boolean isCarExistsByYear(@PathVariable("year") Integer year) {
        return carManager.isCarExistsByYear(year);
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