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

    @Query("SELECT c FROM Car c WHERE c.brand LIKE :brand")
    List<Car> findCarsByBrandWithQuery(String brand);

    List<Car> findCarsByModel(String model);

    @Query("SELECT c FROM Car c WHERE c.model LIKE '%Yar%'")
    List<Car> findCarsByModelWithQueryLike(String model);

    @Query("SELECT c FROM Car c WHERE c.model LIKE :model")
    List<Car> findCarsByModelWithQuery(String model);

    List<Car> findCarsByAge(Integer age);

    @Query("SELECT c FROM Car c WHERE c.age BETWEEN 5 AND 10")
    List<Car> findCarsByAgeWithQuery(Integer age);

    List<Car> findCarsByBrandOrModelOrAge(String brand, String model, Integer age);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE :brand OR c.model LIKE :model OR c.age= :age")
    List<Car> findCarsByBrandOrModelOrAgeWithQuery(String brand, String model, Integer age);

    Long countCarByBrand(String brand);

    @Query("SELECT COUNT(c) FROM Car c WHERE c.brand LIKE :brand")
    Long countCarByBrandWithQuery(String brand);

    Long countCarByModel(String model);

    @Query("SELECT COUNT (c) FROM Car c WHERE c.model LIKE :model")
    Long countCarByModelWithQuery(String model);

    Long countCarByAge(Integer age);

    @Query("SELECT COUNT (c) FROM Car c WHERE c.age= :age")
    Long countCarByAgeWithQuery(Integer age);

    Boolean existsCarByBrand(String brand);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c where c.brand LIKE :brand")
    Boolean existsCarByBrandWithQuery(String brand);

    Boolean existsCarByModel(String model);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c WHERE c.model LIKE :model")
    Boolean existsCarByModelWithQuery(String model);

    Boolean existsCarByAge(Integer age);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c WHERE c.age= :age")
    Boolean existsCarByAgeWithQuery(Integer age);
}