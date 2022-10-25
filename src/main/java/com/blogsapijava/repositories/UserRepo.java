package com.blogsapijava.repositories;

import com.blogsapijava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
