package com.java.springbootapplication.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Set<UserDto> users = new HashSet<>();

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", users=" + users +
                '}';
    }
}
