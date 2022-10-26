package com.blogsapijava.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter @Setter
public class UserUpdateDTO {

    @Size(min = 3, max = 50)
    private String displayName, password;

    @Size(max = 255)
    @Email
    private String email;

    @Size(max = 255)
    private String image;
}
