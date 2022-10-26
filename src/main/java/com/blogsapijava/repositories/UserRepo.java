package com.blogsapijava.repositories;

import com.blogsapijava.dtos.UserResponseDTO;
import com.blogsapijava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select u from User as u where u.id = ?1")
    Optional<UserResponseDTO> basicFindById(long id);
    Optional<User> findByEmail(String email);
}
