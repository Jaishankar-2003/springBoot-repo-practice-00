package com.spring.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//import java.lang.classfile.Superclass;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException
{
    public ResourceNotFound(String message)
    {
        super(message);

    }
}
