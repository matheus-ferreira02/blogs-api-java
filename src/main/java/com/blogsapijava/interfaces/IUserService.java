package com.blogsapijava.interfaces;

import com.blogsapijava.models.User;

import java.util.List;

public interface IUserService {
    User findById(long id);
    User create(User user);
    List<User> findAll();
    void update(User user, long id);
    void delete(long id);
}
