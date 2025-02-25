package com.qa.uam.sid.projet.test.integration.web;

import com.qa.uam.sid.projet.test.integration.model.User;
import com.qa.uam.sid.projet.test.integration.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserServiceImpl service;

    User user;

    List<User> users;

    @BeforeEach
    void setUp() {
        user =  new User(1L, "ngom", "bass", 69,true);
        users = List.of(
                new User(1L, "ngom", "bass", 69,true),
                new User(2L, "Diop", "Fatou", 9,true),
                new User(3L, "FAll", "Alioune", 6,true)
        );
    }

    @Test
    void shouldReturnOneUserViaController() throws Exception {
        when(service.findUserById(1L)).thenReturn(Optional.ofNullable(user));

        mockMvc
                .perform(get("/test/integrations/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("ngom"));


    }


}