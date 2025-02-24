package com.qa.uam.sid.projet.test.integration.service;

import com.qa.uam.sid.projet.test.integration.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> findUserById(Long id);

    void createUser(User user);

    void deletUser(Long id);

    void modifierUser(User user);
}
