package com.blogsapijava.dtos;

import com.blogsapijava.enums.ValidationsMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    // @NotBlank(message = "Field is required and cannot be empty")
    // @Size(min = 3, max = 50, message = "Field must be 3 to 50 characters long")
    @NotBlank
    @Size
    private String displayName, password;

    @NotBlank
    @Size
    @Email
    private String email;

    @Size
    private String image;
}
