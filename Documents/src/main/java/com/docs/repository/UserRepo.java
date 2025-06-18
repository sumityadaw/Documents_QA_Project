package com.docs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.docs.entity.Users;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
}
