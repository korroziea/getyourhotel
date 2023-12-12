package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
}
