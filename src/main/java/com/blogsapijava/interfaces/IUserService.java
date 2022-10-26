package com.blogsapijava.interfaces;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.dtos.UserUpdateDTO;
import com.blogsapijava.models.User;

import java.util.List;

public interface IUserService {
    User findById(long id);
    User create(UserRequestDTO user);
    List<User> findAll();
    void update(UserUpdateDTO dataUserUpdate, long id);
    void delete(long id);
}
