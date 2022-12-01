package org.soulcodeacademy.helpr.services.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(RecursoNaoEncontradoError.class)
    public ResponseEntity<CustomErrorResponse> recursoNaoEncontradoError(RecursoNaoEncontradoError erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setTimestamp(LocalDateTime.now()); // Define a data e a hora em que o erro ocorreu
        response.setStatus(HttpStatus.NOT_FOUND.value()); // Define como 404 o código de status
        response.setMessage(erro.getMessage()); // Define a mensagem de erro vinda do service
        response.setPath(request.getRequestURI()); // Define qual o endpoint ocorreu a requisição

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ParametrosInsuficientesError.class)
    public ResponseEntity<CustomErrorResponse> parametrosInsuficientesError(ParametrosInsuficientesError erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(erro.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> badCredentialsException(BadCredentialsException erro, HttpServletRequest request) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setStatus(HttpStatus.FORBIDDEN.value()); // erro 403
        response.setMessage("Email/senha inválidos");
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}
