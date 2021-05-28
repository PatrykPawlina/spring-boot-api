package com.java.springbootapplication.dao.repo;

import com.java.springbootapplication.dao.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

    List<Car> findCarsByCarBrand(String carBrand);

    List<Car> findCarsByModel(String carModel);

    List<Car> findCarsByAge(Integer carAge);

    List<Car> findCarsByCarBrandOrModelOrAge(String carBrand, String carModel, Integer ageCar);
}
