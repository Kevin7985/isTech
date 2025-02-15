package com.istech.exceptions;

import com.istech.exceptions.exceptions.InternalServerErrorException;
import com.istech.exceptions.models.ApiError;
import com.istech.users.exceptions.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({
            org.springframework.dao.DataIntegrityViolationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError springValidationHandler(final DataIntegrityViolationException e) {
        return new ApiError(
                HttpStatus.BAD_REQUEST.name(),
                e.getMessage()
        );
    }

    @ExceptionHandler({
            InternalServerErrorException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError internalServerErrorHandler(final InternalServerErrorException e) {
        return new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                e.getMessage()
        );
    }

    @ExceptionHandler({
            UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError entityNotFoundHandler(final RuntimeException e) {
        return new ApiError(
                HttpStatus.NOT_FOUND.toString(),
                e.getMessage()
        );
    }
}
