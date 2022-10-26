package com.blogsapijava.interfaces;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.dtos.UserResponseDTO;
import com.blogsapijava.dtos.UserUpdateDTO;
import com.blogsapijava.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User findById(long id);
    UserResponseDTO basicFindById(long id);
    User create(UserRequestDTO user);
    List<User> findAll();
    void update(UserUpdateDTO dataUserUpdate, long id);
    void delete(long id);
    User findByEmail(String email);
}
