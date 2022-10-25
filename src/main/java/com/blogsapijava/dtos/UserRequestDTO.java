package com.blogsapijava.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {

    @NotNull(message = "displayName is required")
    @Size(max = 50, message = "Maximum length 0f 50 characters reached")
    private String displaName;

    @NotNull(message = "password is required")
    @Size(max = 50, message = "Maximum length 0f 50 characters reached")
    private String password;

    @NotNull(message = "email is required")
    @Size(max = 200, message = "Maximum length 0f 200 characters reached")
    @Email(message = "Email is not valid")
    private String email;

    @Size(max = 255, message = "Maximum length 0f 255 characters reached")
    private String image;
}
