package com.java.springbootapplication.repository;

import com.java.springbootapplication.entity.Car;
import com.java.springbootapplication.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByBrand(String brand);

    Car getCarById(Long id);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE '%ss%'")
    List<Car> findCarsByBrandWithQueryLike(String brand);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE :brand")
    List<Car> findCarsByBrandWithQuery(String brand);

    List<Car> findCarsByModel(String model);

    @Query("SELECT c FROM Car c WHERE c.model LIKE '%Yar%'")
    List<Car> findCarsByModelWithQueryLike(String model);

    @Query("SELECT c FROM Car c WHERE c.model LIKE :model")
    List<Car> findCarsByModelWithQuery(String model);

    List<Car> findCarsByYear(Integer year);

    @Query("SELECT c FROM Car c WHERE c.year BETWEEN 5 AND 10")
    List<Car> findCarsByYearWithQuery(Integer year);

    List<Car> findCarsByBrandOrModelOrYear(String brand, String model, Integer year);

    Page<Car> findCarsByBrandOrModelOrYear(String brand, String model, Integer year, Pageable pageable);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE :brand OR c.model LIKE :model OR c.year= :year")
    Page<Car> findCarsByBrandOrModelOrYearWithQueryAndPagination(String brand, String model, Integer year, Pageable pageable);

    @Query("SELECT c FROM Car c WHERE c.brand LIKE :brand OR c.model LIKE :model OR c.year= :year")
    List<Car> findCarsByBrandOrModelOrYearWithQuery(String brand, String model, Integer year);

    @Query("SELECT c FROM Car c WHERE c.users IS NOT EMPTY")
    List<Car> findCarsByUsers(User user);

    Long countCarByBrand(String brand);

    @Query("SELECT COUNT(c) FROM Car c WHERE c.brand LIKE :brand")
    Long countCarByBrandWithQuery(String brand);

    Long countCarByModel(String model);

    @Query("SELECT COUNT (c) FROM Car c WHERE c.model LIKE :model")
    Long countCarByModelWithQuery(String model);

    Long countCarByYear(Integer year);

    @Query("SELECT COUNT (c) FROM Car c WHERE c.year= :year")
    Long countCarByYearWithQuery(Integer year);

    Boolean existsCarByBrand(String brand);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c where c.brand LIKE :brand")
    Boolean existsCarByBrandWithQuery(String brand);

    Boolean existsCarByModel(String model);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c WHERE c.model LIKE :model")
    Boolean existsCarByModelWithQuery(String model);

    Boolean existsCarByYear(Integer year);

    @Query("SELECT CASE WHEN COUNT (c) > 0 THEN TRUE ELSE FALSE END FROM Car c WHERE c.year= :year")
    Boolean existsCarByYearWithQuery(Integer year);
}