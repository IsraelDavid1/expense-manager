package com.israel.expensemanager.infra;

import com.israel.expensemanager.exceptions.ExpenseIdNotFoundException;
import com.israel.expensemanager.exceptions.InvalidDateRangeException;
import com.israel.expensemanager.exceptions.InvalidOrExpiredTokenException;
import com.israel.expensemanager.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExpenseIdNotFoundException.class)
    public ResponseEntity<RestErrorMessage> expenseIdNotFoundHandler(ExpenseIdNotFoundException exception) {
        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, "expense not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException exception) {
        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, "user not found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidDateRangeException.class)
    public ResponseEntity<RestErrorMessage> invalidDateRangeHandler(InvalidDateRangeException exception) {
        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "invalid date range");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InvalidOrExpiredTokenException.class)
    public ResponseEntity<RestErrorMessage> InvalideOrExpiredTokenHandler(InvalidOrExpiredTokenException exception) {
        RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Invalid or expired token");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
