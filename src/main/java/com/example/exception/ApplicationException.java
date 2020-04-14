package com.example.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * This class provides a checked exception for applications. The supporting
 * methods can be found in helper class - {@link ApplicationExceptionHelper}
 * 
 * @author ritika.goel
 *
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787403205437983832L;

	private Map<String, Object> errorResponse;
	private HttpStatus httpStatus;

	ApplicationException(Map<String, Object> errorResponse, HttpStatus httpStatus) {
		this.errorResponse = errorResponse;
		this.httpStatus = httpStatus;
	}

	/**
	 * This method acts as a getter for errorResponce instance variable.
	 * 
	 * @return This returns the error scenario response object. 
	 */
	public Map<String, Object> getErrorResponse() {
		return errorResponse;
	}

	/**
	 * This method acts as a getter for httpStatus instance variable.
	 * 
	 * @return This returns the error scenario Http Status. 
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
