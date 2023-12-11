package com.rubashenko.getyourhotel.repository;

import com.rubashenko.getyourhotel.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    void addRoleToUser(Long userId, String roleName);
}
