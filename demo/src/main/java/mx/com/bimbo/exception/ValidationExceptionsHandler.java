package mx.com.bimbo.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.bimbo.dto.ErrorResponseDTO;

@ControllerAdvice
public class ValidationExceptionsHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handle(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        var errorResponseDTO = ErrorResponseDTO.builder()
                .errors(errors)
                .build();

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        return (ResponseEntity<ErrorResponseDTO>) ResponseEntity.status(status).body(errorResponseDTO);
    }
}
