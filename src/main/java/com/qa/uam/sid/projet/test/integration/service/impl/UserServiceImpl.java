package com.qa.uam.sid.projet.test.integration.service.impl;

import com.qa.uam.sid.projet.test.integration.model.User;
import com.qa.uam.sid.projet.test.integration.repo.UserRepository;
import com.qa.uam.sid.projet.test.integration.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    // @Autowire
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void deletUser(Long id) {
        Optional<User> user= this.userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    @Override
    public void modifierUser(User user) {
        userRepository.save(user);
    }
}
