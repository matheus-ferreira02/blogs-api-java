package com.blogsapijava.exceptions;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String title, message;
    private int status;
    private LocalDateTime timestamps;
}
