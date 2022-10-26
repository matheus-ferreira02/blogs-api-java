package com.blogsapijava.services;

import com.blogsapijava.dtos.UserRequestDTO;
import com.blogsapijava.dtos.UserResponseDTO;
import com.blogsapijava.dtos.UserUpdateDTO;
import com.blogsapijava.exceptions.EmailExistsException;
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

    @Override
    public UserResponseDTO basicFindById(long id) {
        Optional<UserResponseDTO> user = repo.basicFindById(id);

        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User create(UserRequestDTO userDTO) {
        User user = new User();
        verifyExistingEmail(userDTO.getEmail());
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
    public void update(UserUpdateDTO dataUserUpdate, long id) {
        User user = this.findById(id);
        // primeira abordagem, pegar cada valor do DTO, verificar se existe e atualizar, setando cada valor, mas caso existe 50 atributos, ficaria enorme
        // ou poderia criar uma rota para att cada atributo
        if (dataUserUpdate.getDisplayName() != null) user.setDisplayName(dataUserUpdate.getDisplayName());
        if (dataUserUpdate.getImage() != null) user.setImage(dataUserUpdate.getImage());
        if (dataUserUpdate.getPassword() != null) user.setPassword(dataUserUpdate.getPassword());

        if (dataUserUpdate.getEmail() != null) verifyExistingEmail(dataUserUpdate.getEmail());
        // outra forma, simplesmente setar o novo valor, e deixar que a própria model verifique isso
        user.setEmail(dataUserUpdate.getEmail());

        repo.save(user);
    }

    @Override
    public void delete(long id) {
        this.findById(id);

        repo.deleteById(id);
    }

    public User findByEmail(String email) {
        Optional<User> user = repo.findByEmail(email);

        return user.orElseThrow(() -> new NotFoundException("User not found"));
    }

    private void verifyExistingEmail(String email) {
        Optional<User> user = repo.findByEmail(email);

        if (user.isPresent()) throw new EmailExistsException("Email is already in use");
    }
}
