package com.blogsapijava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Field is required and cannot be empty")
    @Size(min = 3, max = 50, message = "Field must be 3 to 50 characters long")
    private String displayName, password;

    @NotBlank(message = "Field is required and cannot be empty")
    @Size(max = 200, message = "Maximum length 0f 200 characters reached")
    @Email(message = "Email is not valid")
    private String email;

    @Size(max = 255, message = "Maximum length 0f 255 characters reached")
    private String image;
}
