package org.example.colorado.repository;

import org.example.colorado.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByTelephoneNumber(String telephoneNumber);
    Optional<Users> findByName(String name);

}
