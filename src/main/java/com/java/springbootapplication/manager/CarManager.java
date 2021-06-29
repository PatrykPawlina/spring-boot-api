package com.java.springbootapplication.manager;

import com.java.springbootapplication.dao.entity.Car;
import com.java.springbootapplication.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManager {

    private CarRepository carRepository;

    @Autowired
    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> findCarsByBrand(String brand) {
        return carRepository.findCarsByBrand(brand);
    }

    public List<Car> findCarsByBrandWithQueryLike(String brand) {
        return carRepository.findCarsByBrandWithQueryLike(brand);
    }

    public List<Car> findCarsByBrandWithQuery(String brand) {
        return carRepository.findCarsByBrandWithQuery(brand);
    }

    public List<Car> findCarsByModel(String model) {
        return carRepository.findCarsByModel(model);
    }

    public List<Car> findCarsByModelWithQueryLike(String model) {
        return carRepository.findCarsByModelWithQueryLike(model);
    }

    public List<Car> findCarsByModelWithQuery(String model) {
        return carRepository.findCarsByModelWithQuery(model);
    }

    public List<Car> findCarsByAge(Integer age) {
        return carRepository.findCarsByAge(age);
    }

    public List<Car> findCarsByAgeWithQuery(Integer age) {
        return carRepository.findCarsByAgeWithQuery(age);
    }

    public List<Car> findCarsByBrandOrModelOrAge(String brand, String model, Integer age) {
        return carRepository.findCarsByBrandOrModelOrAge(brand, model, age);
    }

    public Long countCars() {
        return carRepository.count();
    }

    public Long countCarsByBrand(String brand) {
        return carRepository.countCarByBrand(brand);
    }

    public Long countCarsByModel(String model) {
        return carRepository.countCarByModel(model);
    }

    public Long countCarsByAge(Integer age) {
        return carRepository.countCarByAge(age);
    }

    public Boolean isCarExistsById(Long id) {
        return carRepository.existsById(id);
    }

    public Boolean isCarExistsByBrand(String brand) {
        return carRepository.existsCarByBrand(brand);
    }

    public Boolean isCarExistsByModel(String model) {
        return carRepository.existsCarByModel(model);
    }

    public Boolean isCarExistsByAge(Integer age) {
        return carRepository.existsCarByAge(age);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public void deleteAll() {
        carRepository.deleteAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        saveCar(new Car(1L, "Nissan", "Juke", 1));
        saveCar(new Car(2L, "Mazda", "CX30", 3));
        saveCar(new Car(3L, "Toyota", "Yaris", 5));
        saveCar(new Car(4L, "Suzuki", "Swift", 7));
        saveCar(new Car(5L, "Volvo", "XC90", 12));
        saveCar(new Car(6L, "BMW", "M3", 9));
        saveCar(new Car(7L, "Subaru", "Forester", 8));
        saveCar(new Car(8L, "Peugeot", "2008", 4));
    }
}