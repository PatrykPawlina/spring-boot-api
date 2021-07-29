package com.java.springbootapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.springbootapplication.dto.GenderDto;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GenderDto gender;
    private String firstName;
    private String lastName;
    private Integer age;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private DrivingLicense drivingLicense;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_car",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> cars = new HashSet<>();

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", drivingLicense=" + drivingLicense +
                ", address=" + address +
                ", cars=" + cars +
                '}';
    }
}