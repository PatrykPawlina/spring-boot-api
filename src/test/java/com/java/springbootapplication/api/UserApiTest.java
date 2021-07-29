package com.java.springbootapplication.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.springbootapplication.entity.User;
import com.java.springbootapplication.repository.UserRepository;
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
class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetUserById() throws Exception {

        // given
        User user = new User();

        user.setId(1L);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/users/id/" + user.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(user.getId().intValue())))
                .andReturn();

        // then
        User userResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
        assertThat(userResult).isNotNull();
        assertThat(userResult.getId()).isEqualTo(1L);
        assertThat(userResult.getFirstName()).isEqualTo("Katarzyna");
        assertThat(userResult.getLastName()).isEqualTo("Grudzień");
        assertThat(userResult.getAge()).isEqualTo(33);
    }
}
