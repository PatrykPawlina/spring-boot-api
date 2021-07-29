package com.java.springbootapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private GenderDto gender;
    private String firstName;
    private String lastName;
    private Integer age;
    private DrivingLicenseDto drivingLicense;
    private AddressDto address;
    private Set<CarDto> cars = new HashSet<>();

    @Override
    public String toString() {
        return "UserDto{" +
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
