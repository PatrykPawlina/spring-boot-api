package com.java.springbootapplication.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carBrand;
    private String model;
    private Integer age;

    public Car() {
    }

    public Car(Long id, String carBrand, String model, Integer age) {
        this.id = id;
        this.carBrand = carBrand;
        this.model = model;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
