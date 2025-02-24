package com.qa.uam.sid.projet.test.integration.repo;

import com.qa.uam.sid.projet.test.integration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
