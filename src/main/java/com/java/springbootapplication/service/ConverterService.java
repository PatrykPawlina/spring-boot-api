package com.java.springbootapplication.service;

import com.java.springbootapplication.dao.CarDto;
import com.java.springbootapplication.entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterService {

    private final ModelMapper modelMapper;

    @Autowired
    public ConverterService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarDto convertToDto(Car carObject) {
        return modelMapper.map(carObject, CarDto.class);
    }
}