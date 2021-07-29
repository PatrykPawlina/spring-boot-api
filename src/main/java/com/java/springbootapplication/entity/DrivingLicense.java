package com.java.springbootapplication.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numberDrivingLicense;
    private String drivingLicenseCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public DrivingLicense() {
    }

    public void setId(Long id) {
        this.id = id;
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
                ", numberDrivingLicense='" + numberDrivingLicense + '\'' +
                ", drivingLicenseCategory='" + drivingLicenseCategory + '\'' +
                ", user=" + user +
                '}';
    }
}