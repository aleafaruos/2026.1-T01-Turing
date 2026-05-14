package br.com.seuespacounb.turing.handler;

import br.com.seuespacounb.turing.exception.ConflictException;
import br.com.seuespacounb.turing.exception.MethodArgumentNotValidException;
import br.com.seuespacounb.turing.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.com.seuespacounb.turing.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse>  handlerNotFoundException(NotFoundException exception){
        ErrorResponse response = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<ErrorResponse> handlerConflictException(ConflictException exception){
        ErrorResponse response = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ErrorResponse response = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

