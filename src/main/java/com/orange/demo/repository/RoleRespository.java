package com.orange.demo.repository;

import com.orange.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRespository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}