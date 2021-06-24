package com.java.springbootapplication.dao.repository;

import com.java.springbootapplication.dao.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarsByBrand(String brand);

    List<Car> findCarsByModel(String model);

    List<Car> findCarsByAge(Integer age);

    List<Car> findCarsByBrandOrModelOrAge(String brand, String model, Integer age);

    Long countCarByBrand(String brand);

    Long countCarByModel(String model);

    Long countCarByAge(Integer age);

    Boolean existsCarByBrand(String brand);

    Boolean existsCarByModel(String model);

    Boolean existsCarByAge(Integer age);
}
