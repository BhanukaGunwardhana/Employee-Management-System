package com.example.User.Exceptionhandler;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventHandleException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;
    
}
