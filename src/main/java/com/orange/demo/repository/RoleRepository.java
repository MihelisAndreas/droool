package com.orange.demo.repository;

import com.orange.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRole(String role);
}
