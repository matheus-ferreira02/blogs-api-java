package com.blogsapijava.services;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.interfaces.IUserService;
import com.blogsapijava.models.User;
import com.blogsapijava.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {

    @Autowired
    private UserRepo repo;

    @Override
    public User findById(long id) throws Exception {
        Optional<User> user = repo.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("Inexistente");
    }

    @Override
    public User create(UserRequestDTO user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user, long id) {

    }

    @Override
    public void delete(long id) {

    }
}
