package com.java.springbootapplication.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Long id;
    private String city;
    private String codePostal;
    private String street;
    private Integer buildingNumber;
    private Integer apartmentNumber;
    private Set<UserDto> users = new HashSet<>();

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", users=" + users +
                '}';
    }
}
