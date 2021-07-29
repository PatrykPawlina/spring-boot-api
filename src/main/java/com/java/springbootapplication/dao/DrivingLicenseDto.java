package com.java.springbootapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrivingLicenseDto {

    private Long id;
    private String numberDrivingLicense;
    private String drivingLicenseCategory;
    private UserDto user;

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "id=" + id +
                ", numberDrivingLicense='" + numberDrivingLicense + '\'' +
                ", drivingLicenseCategory='" + drivingLicenseCategory + '\'' +
                ", user=" + user +
                '}';
    }
}
