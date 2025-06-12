package it.epicode.W6_D2_BE.exceptions;



import it.epicode.W6_D2_BE.model.ApiError;
import jakarta.validation.ValidationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//rende più leggibili gli errori
@RestController //controller che gestisce gli errori
public class CustomizedExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class) //tipo mapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError notFoundExceptionHandler(ChangeSetPersister.NotFoundException e){
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;

    }

    @ExceptionHandler(ValidationException.class) //tipo mapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError ValidationExceptionHandler(ValidationException e){
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;

    }
}
