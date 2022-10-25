package com.blogsapijava.exceptions;

import lombok.*;

@Getter
@Setter
@Builder
public class FieldMessage {
    private String field;
    private String message;
}
