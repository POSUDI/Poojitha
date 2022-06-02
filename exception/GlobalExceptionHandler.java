package com.VehicleProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
    }
	
	@ExceptionHandler(value = VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
	}
	
	@ExceptionHandler(value = VehicleBookingNotFoundException.class)
    public ResponseEntity<String> handleVehicleBookingNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
	}
	
	@ExceptionHandler(value = QueryTextNotFoundException.class)
    public ResponseEntity<String> handleQueryTextNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
	}
	
	@ExceptionHandler(value = FeedbackNotFoundException.class)
    public ResponseEntity<String> handleFeedbackNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
	}
	
	@ExceptionHandler(value = AdminNotFoundException.class)
    public ResponseEntity<String> handleAdminNotFoundException(Exception e)
	{
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        return responseEntity;
	}
}
