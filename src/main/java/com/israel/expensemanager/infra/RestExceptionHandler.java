package com.israel.expensemanager.infra;

import com.israel.expensemanager.exceptions.ExpenseIdNotFoundException;
import com.israel.expensemanager.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExpenseIdNotFoundException.class)
    private ResponseEntity<RestErrorMessage> expenseIdNotFoundHandler(ExpenseIdNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, "expense not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException exception) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, "user not found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
}
