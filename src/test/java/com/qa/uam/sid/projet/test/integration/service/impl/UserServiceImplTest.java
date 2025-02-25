package com.qa.uam.sid.projet.test.integration.service.impl;

import com.qa.uam.sid.projet.test.integration.model.User;
import com.qa.uam.sid.projet.test.integration.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    List<User> users;

    User user;

    @BeforeEach
    void setUp() {
        users = List.of(
                new User(1L, "ngom", "bass", 69,true),
                new User(2L, "Diop", "Fatou", 9,true),
                new User(3L, "FAll", "Alioune", 6,true)
        );

        user = users.get(0);
    }

    @Test
    void shouldReturnAllUserFromService(){
        // donnees static
                // When
        when(userRepository.findAll()).thenReturn(users);

        List<User> users1 = userService.getAllUsers();
        Assert.notEmpty(users1, " Liste d'utilisateur non vide");
        Assert.isTrue(users1.size() == 3, " il y'a que 3 utilisateurs dans la bd");
        Assert.isTrue(users1.get(0).getNom().equals("ngom"), "le premier utiliseur a pour nom 'ngom'");
    }

    @Test
    void shouldReturnAUser(){
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> user1 = userService.findUserById(1L);

        Assert.notNull(user1, " il doit y avoir forcement un utilisateur");
        assertFalse(user1.isEmpty());
        Assertions.assertSame(user1.get().getNom(), "ngom");
    }

    @Test
    void  shouldCallCreateUser(){
        // doNothing utilisé pour les methodes void

        // test de la creation cote repository
        when(userRepository.save(user)).thenReturn(user);

        // simule la creation
        userService.createUser(user);

        // verification de l'appel save du reposity
        verify(userRepository, times(1)).save(user);

    }

    @Test
    void shouldDeleteUser(){

        // simulation
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));

        doNothing().when(userRepository).delete(user);


        // execution
        userService.deletUser(1L);


        // verification
        verify(userRepository, times(1)).delete(user);

    }



}