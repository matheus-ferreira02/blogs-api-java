package com.blogsapijava.exceptions;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String title, message;
    private int status;
    private List<FieldMessage> fields;
    private LocalDateTime timestamps;
}
