package org.example.colorado.repository;


import org.example.colorado.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String name);
    Optional<Role> findById(Integer id); // Update to use Integer id instead of String role
}
