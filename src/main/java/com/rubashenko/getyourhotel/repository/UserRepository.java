package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    User findUserByEmail(String email);
    User findUserById(Long id);
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName WHERE u.id = :id")
    void updateUserById(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName);
}
