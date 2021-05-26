package com.java.springbootapplication.dao.repo;

import com.java.springbootapplication.dao.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

}
