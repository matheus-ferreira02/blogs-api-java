package com.blogsapijava.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class BlogPostRequestDTO {
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank
    @Size(min = 10, max = 255)
    private String content;

    @NotNull
    @Min(0)
    private long userId;

    @NotEmpty
    @NotNull
    private List<Long> categories;
}
