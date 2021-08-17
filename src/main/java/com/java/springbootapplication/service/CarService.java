package com.java.springbootapplication.service;

import com.java.springbootapplication.dto.CarDto;
import com.java.springbootapplication.entity.Car;
import com.java.springbootapplication.entity.User;
import com.java.springbootapplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;
    private ConverterService converterService;

    @Autowired
    public CarService(CarRepository carRepository, ConverterService converterService) {
        this.carRepository = carRepository;
        this.converterService = converterService;
    }

    public List<CarDto> getAllCars() {
        List<Car> carDataList = carRepository.findAll();
        return carDataList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public CarDto getCarById(Long id) {
        Car carObject = carRepository.getCarById(id);
        return converterService.convertCarToDto(carObject);
    }

    public CarDto getCarByIdWithQuery(Long id) {
        Car carObject = carRepository.getCarByIdWithQuery(id);
        return converterService.convertCarToDto(carObject);
    }

    public List<CarDto> findCarsByBrand(String brand) {
        List<Car> carObjectList = carRepository.getCarsByBrand(brand);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByBrandWithQueryLike(String brand) {
        List<Car> carObjectList = carRepository.getCarsByBrandWithQueryLike(brand);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByBrandWithQuery(String brand) {
        List<Car> carObjectList = carRepository.getCarsByBrandWithQuery(brand);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByModel(String model) {
        List<Car> carObjectList = carRepository.getCarsByModel(model);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());

    }

    public List<CarDto> getCarsByModelWithQueryLike(String model) {
        List<Car> carObjectList = carRepository.getCarsByModelWithQueryLike(model);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByModelWithQuery(String model) {
        List<Car> carObjectList = carRepository.getCarsByModelWithQuery(model);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByYear(Integer year) {
        List<Car> carObjectList = carRepository.getCarsByYear(year);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByYearWithQuery(Integer year) {
        List<Car> carObjectList = carRepository.getCarsByYearWithQuery(year);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsByBrandOrModelOrYear(String brand, String model, Integer year) {
        List<Car> carObjectList = carRepository.getCarsByBrandOrModelOrYear(brand, model, year);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public Page<Car> findCarsByBrandOrModelOrYearWithPagination(String brand, String model, Integer year, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return carRepository.findCarsByBrandOrModelOrYear(brand, model, year, pageable);
    }

    public Page<Car> findCarsByBrandOrModelOrYearWithQueryAndPagination(String brand, String model, Integer year, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return carRepository.findCarsByBrandOrModelOrYearWithQueryAndPagination(brand, model, year, pageable);
    }

    public List<CarDto> getCarsByBrandOrModelOrYearWithQuery(String brand, String model, Integer year) {
        List<Car> carObjectList = carRepository.getCarsByBrandOrModelOrYearWithQuery(brand, model, year);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public List<CarDto> getCarsWithUsers(User user) {
        List<Car> carObjectList = carRepository.getCarsByUsers(user);
        return carObjectList.stream().map(converterService::convertCarToDto).collect(Collectors.toList());
    }

    public Long countCars() {
        return carRepository.count();
    }

    public Long countCarsByBrand(String brand) {
        return carRepository.countCarByBrand(brand);
    }

    public Long countCarsByBrandWithQuery(String brand) {
        return carRepository.countCarByBrandWithQuery(brand);
    }

    public Long countCarsByModel(String model) {
        return carRepository.countCarByModel(model);
    }

    public Long countCarsByModelWithQuery(String model) {
        return carRepository.countCarByModelWithQuery(model);
    }

    public Long countCarsByYear(Integer year) {
        return carRepository.countCarByYear(year);
    }

    public Long countCarsByYearWithQuery(Integer year) {
        return carRepository.countCarByYearWithQuery(year);
    }

    public Boolean isCarExistsById(Long id) {
        return carRepository.existsById(id);
    }

    public Boolean isCarExistsByBrand(String brand) {
        return carRepository.existsCarByBrand(brand);
    }

    public Boolean isCarExistsByBrandWithQuery(String brand) {
        return carRepository.existsCarByBrandWithQuery(brand);
    }

    public Boolean isCarExistsByModel(String model) {
        return carRepository.existsCarByModel(model);
    }

    public Boolean isCarExistsByModelWithQuery(String model) {
        return carRepository.existsCarByModelWithQuery(model);
    }

    public Boolean isCarExistsByYear(Integer year) {
        return carRepository.existsCarByYear(year);
    }

    public Boolean isCarExistsByYearWithQuery(Integer year) {
        return carRepository.existsCarByYearWithQuery(year);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}