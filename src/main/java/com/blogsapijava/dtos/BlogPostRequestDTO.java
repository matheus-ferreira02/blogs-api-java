package com.blogsapijava.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class BlogPostRequestDTO {
    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 255)
    private String content;

    @NotNull
    @Min(0)
    private long userId;
}
