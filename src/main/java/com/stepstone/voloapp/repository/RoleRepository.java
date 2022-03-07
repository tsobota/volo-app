package com.stepstone.voloapp.repository;

import com.stepstone.voloapp.domain.ERole;
import com.stepstone.voloapp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
