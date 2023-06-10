package com.yuba.cafe.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericExceptionMessage extends RuntimeException {
    private String message;
}
