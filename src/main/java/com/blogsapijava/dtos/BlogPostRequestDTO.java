package com.blogsapijava.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BlogPostRequestDTO {
    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 255)
    private String content;

    @NotBlank
    private long userId;
}
