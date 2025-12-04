package com.mauro.authapi.repository;

import com.mauro.authapi.model.Role;
import com.mauro.authapi.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
