package com.blogsapijava.dtos;

import com.blogsapijava.controllers.EnumTest;
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
    // @NotBlank(message = EnumTest.REQUIRED.getMessage())
    // @Size(min = 3, max = 50, message = "Field must be 3 to 50 characters long")
    @NotBlank
    @Size(min = 3, max = 50)
    private String displayName, password;

    @NotBlank
    @Size(max = 255)
    @Email
    private String email;

    @Size(max = 255)
    private String image;
}
