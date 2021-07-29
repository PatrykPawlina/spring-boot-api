package com.java.springbootapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonIgnore
    private Long id;
    private GenderDto gender;
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
