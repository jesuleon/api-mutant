package com.mercadolibre.domain.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> handleExceptions(HttpServletRequest req, Exception ex) {

        logger.error(ex.getMessage(), ex);

        return ResponseEntity.badRequest().build();
    }

}