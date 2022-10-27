package com.blogsapijava.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class BlogPostRequestDTO {
    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 255)
    private String content;

    @NotBlank
    private long userId;
}
