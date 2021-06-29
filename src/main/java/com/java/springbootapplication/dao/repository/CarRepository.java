package com.java.springbootapplication.dao.repository;

import com.java.springbootapplication.dao.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarsByBrand(String brand);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE '%ss%'")
    List<Car> findCarsByBrandWithQueryLike(String brand);

    @Query("SELECT c FROM Car c WHERE c.brand=?1")
    List<Car> findCarsByBrandWithQuery(String brand);

    List<Car> findCarsByModel(String model);

    @Query("SELECT c FROM Car c WHERE c.model LIKE '%Yar%'")
    List<Car> findCarsByModelWithQueryLike(String model);

    @Query("SELECT c FROM Car c WHERE c.model=?1")
    List<Car> findCarsByModelWithQuery(String model);

    List<Car> findCarsByAge(Integer age);

    @Query("SELECT c FROM Car c WHERE c.age BETWEEN 5 AND 10")
    List<Car> findCarsByAgeWithQuery(Integer age);

    List<Car> findCarsByBrandOrModelOrAge(String brand, String model, Integer age);

    @Query("SELECT c FROM Car c WHERE c.brand=?1 OR c.model=?2 OR c.age=?3")
    List<Car> findCarsByBrandOrModelOrAgeWithQuery(String brand, String model, Integer age);

    Long countCarByBrand(String brand);

    @Query("SELECT count(c) FROM Car c WHERE c.brand=?1")
    Long countCarByBrandWithQuery(String brand);

    Long countCarByModel(String model);

    Long countCarByAge(Integer age);

    Boolean existsCarByBrand(String brand);

    Boolean existsCarByModel(String model);

    Boolean existsCarByAge(Integer age);
}