package com.oquever.api.application.handler;

import com.oquever.api.application.dto.BaseResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<BaseResponse<Object>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {

    List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.toList());

    BaseResponse<Object> errorResponse = BaseResponse.error(
        "Request error",
        errors);

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

}
