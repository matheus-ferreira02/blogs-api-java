package com.blogsapijava.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CategoryRequestDTO {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
