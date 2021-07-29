package com.java.springbootapplication.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.springbootapplication.entity.Car;
import com.java.springbootapplication.repository.CarRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "patryk", password = "admin")
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetCarById() throws Exception {

        // given
        Car car = new Car();

        car.setId(1L);

//        car.setBrand("Nissan");
//        car.setModel("Juke"); - with Car data without database
//        car.setYear(2021);
//        carRepository.save(car);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/cars/id/" + car.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(car.getId().intValue())))
                .andReturn();

        // then
        Car carResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        assertThat(carResult).isNotNull();
        assertThat(carResult.getId()).isEqualTo(1L);
        assertThat(carResult.getBrand()).isEqualTo("Nissan");
        assertThat(carResult.getModel()).isEqualTo("Juke");
        assertThat(carResult.getYear()).isEqualTo(2021);
    }

    @Test
    void shouldGetCarByBrand() throws Exception {

        // given
        Car car = new Car();
        car.setBrand("Seat");

//        car.setId(23L);
//        car.setModel("Leon");
//        car.setYear(2020);
//        carRepository.save(car);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/cars/brands/" + car.getBrand()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value(car.getBrand()))
                .andReturn();
        
        // then
        Car carResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        assertThat(carResult).isNotNull();
        assertThat(carResult.getId()).isEqualTo(23L);
        assertThat(carResult.getBrand()).isEqualTo("Seat");
        assertThat(carResult.getModel()).isEqualTo("Leon");
        assertThat(carResult.getYear()).isEqualTo(2020);
    }

    @Test
    void shouldGetCarByModel() throws Exception {

        // given
        Car car = new Car();
        car.setModel("Yaris");

//        car.setId(3L);
//        car.setBrand("Toyota");
//        car.setYear(2014);
//        carRepository.save(car);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/cars/models/" + car.getModel()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect((MockMvcResultMatchers.jsonPath("$.model", Matchers.is(car.getModel()))))
                .andReturn();

        // then
        Car carResult1 = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        assertThat(carResult1).isNotNull();
        assertThat(carResult1.getId()).isEqualTo(3L);
        assertThat(carResult1.getBrand()).isEqualTo("Toyota");
        assertThat(carResult1.getModel()).isEqualTo("Yaris");
        assertThat(carResult1.getYear()).isEqualTo(2014);
    }
}