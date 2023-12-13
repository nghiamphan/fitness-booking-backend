package smu.mcda5540.fitnessbooking.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionRestControllerAdvice {
    private final Environment environment;

    @Autowired
    public ExceptionRestControllerAdvice(Environment environment) {
        this.environment = environment;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler() {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), environment.getProperty("ERROR.INTERNAL_SERVER_ERROR"), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FitnessBookingException.class)
    public ResponseEntity<ErrorInfo> fitnessBookingExceptionHandler(Exception e) {
        ErrorInfo errorInfo;
        if(e.getMessage().startsWith("ERROR."))
            errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), environment.getProperty(e.getMessage()), LocalDateTime.now());
        else
            errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> dataIntegrityViolationExceptionHandler(Exception e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}