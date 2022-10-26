package com.blogsapijava.services;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.exceptions.NotFoundException;
import com.blogsapijava.interfaces.IUserService;
import com.blogsapijava.models.User;
import com.blogsapijava.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepo repo;

    @Override
    public User findById(long id) {
        Optional<User> user = repo.findById(id);

        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    // TODO: verificar se o email ja existe antes de criar
    @Override
    public User create(UserRequestDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setDisplayName(userDTO.getDisplayName());
        user.setPassword(userDTO.getPassword());
        user.setImage(userDTO.getImage());

        return repo.save(user);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void update(User user, long id) {

    }

    @Override
    public void delete(long id) {

    }
}
