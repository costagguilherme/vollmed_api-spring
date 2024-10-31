package med.voll.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFoundError() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequestError(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();  
        return ResponseEntity.badRequest().body(
            errors.stream().map(ValidationDataError::new).toList()
        );
    }

    private record ValidationDataError(String field, String message) {
        public ValidationDataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
