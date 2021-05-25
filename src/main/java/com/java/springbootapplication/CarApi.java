package com.java.springbootapplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarApi {

    private List<Car> cars;

    public CarApi() {
        cars = new ArrayList<>();
        cars.add(new Car(1L, "Nissan", "Juke", 1));
        cars.add(new Car(2L, "Mazda", "CX30", 3));
        cars.add(new Car(3L, "Toyota", "Yaris", 5));
        cars.add(new Car(4L, "Suzuki", "Swift", 7));
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return cars;
    }

    @GetMapping
    public Car getCarById(@RequestParam int index) {
        Optional<Car> carById = cars.stream().filter(car -> car.getId() == index).findFirst();
        return carById.get();
    }

    @PostMapping
    public boolean addCar(@RequestBody Car car) {
        return cars.add(car);
    }

    @PutMapping
    public boolean updateCar(@RequestBody Car car) {
        return cars.add(car);
    }

    @DeleteMapping
    public boolean deleteCar(@RequestBody int index) {
        return cars.removeIf(car -> car.getId() == index);
    }
}
