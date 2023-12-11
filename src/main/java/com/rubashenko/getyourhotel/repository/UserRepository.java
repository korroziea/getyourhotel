package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUserByEmail(Users user);
}
