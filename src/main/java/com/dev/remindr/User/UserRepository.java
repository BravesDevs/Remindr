package com.dev.remindr.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    boolean existsByEmail(String email);


    boolean existsById(Long id);
}
