package com.blogsapijava.dtos;

import com.blogsapijava.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class UserResponseDTO {
    private final String displayName, password, email, image;

    public UserResponseDTO(User user) {
        this.displayName = user.getDisplayName();
        this.image = user.getImage();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
