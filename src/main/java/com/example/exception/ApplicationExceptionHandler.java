package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class defines the methods for handling {@link ApplicationException} at
 * runtime.
 * 
 * @author ritika.goel
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

	/**
	 * This method handles the exceptions of type {@link ApplicationException}.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApplicationException> handleException(ApplicationException ex) {
		return new ResponseEntity<>(ex, ex.getHttpStatus());
	}
}
