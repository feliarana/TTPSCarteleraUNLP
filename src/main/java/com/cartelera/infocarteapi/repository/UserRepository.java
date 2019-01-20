package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User repository for CRUD operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByUsername(String username);

//  Optional<User> findByUsernameOrEmail(String username, String email);

  Boolean existsByUsername(String username);

//  Boolean existsByEmail(String email);
}