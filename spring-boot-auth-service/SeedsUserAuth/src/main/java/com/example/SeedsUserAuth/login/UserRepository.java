package com.example.SeedsUserAuth.login;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Here you can define custom query methods if needed
    Optional<User> findByUsername(String username);

}
