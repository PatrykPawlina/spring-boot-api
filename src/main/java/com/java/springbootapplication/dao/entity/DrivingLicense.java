package com.java.springbootapplication.dao.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userFirstName;
    private String userLastName;
    private String numberDrivingLicense;
    private String drivingLicenseCategory;

    @OneToOne(mappedBy = "drivingLicense")
    private User user;

    public DrivingLicense() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setNumberDrivingLicense(String numberDrivingLicense) {
        this.numberDrivingLicense = numberDrivingLicense;
    }

    public void setDrivingLicenseCategory(String drivingLicenseCategory) {
        this.drivingLicenseCategory = drivingLicenseCategory;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "id=" + id +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", numberDrivingLicense='" + numberDrivingLicense + '\'' +
                ", drivingLicenseCategory='" + drivingLicenseCategory + '\'' +
                ", user=" + user +
                '}';
    }
}