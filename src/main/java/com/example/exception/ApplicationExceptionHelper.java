package com.example.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.constants.ApiResponseCode;
import com.example.constants.ResponseKey;
import com.example.constants.Status;

/**
 * This is a helper class and consists of utility methods to create
 * {@link ApplicationException} object.
 * 
 * @author ritika.goel
 *
 */
@Service
public class ApplicationExceptionHelper {

	/**
	 * This method is used to throw {@link ApplicationException} object when an
	 * application level exception occurs. This helps the client in identifying what
	 * was the error source and details of the error occurred.
	 * 
	 * @param responseStatus          - specifies the response responseStatus for the request
	 * @param apiResponseCode - specifies the api response code for the request
	 * @param apiName         - specifies the api name for which this response is
	 *                        being sent
	 * @param errors          - specifies the error sources causing this exception
	 * @throws ApplicationException
	 */
	public void raiseApplicationException(HttpStatus httpStatus, Status status, ApiResponseCode apiResponseCode, String apiName,
			List<Map<String, String>> errors) throws ApplicationException {
		throw getApplicationException(httpStatus, status, apiResponseCode, apiName, errors);
	}

	/**
	 * This method creates the error source object and adds it to the error list.
	 * The list is specific to each caller and needs to be passed as an input by the
	 * caller to populate a global error source list for their API. This method has
	 * an overloaded version. The first time, when the client calls this method,
	 * they should use the overloaded version, and for subsequent calls they can use
	 * this version of the method.
	 * 
	 * @param source  - specifies the source of the error message
	 * @param message - specifies the details of the error
	 * @return
	 */
	public List<Map<String, String>> addErrorSourceToList(String source, String message,
			List<Map<String, String>> errors) {
		if (errors == null)
			errors = new ArrayList<>();
		errors.add(createErrorSource(source, message));
		return errors;
	}

	/**
	 * This method needs to be called by the client application when they are
	 * populating the error source list with the first error source object.
	 * Thereafter, they need to call the overloaded version of this method.
	 * 
	 * @param source  - specifies the source of the error message
	 * @param message - specifies the details of the error
	 * @return
	 */
	public List<Map<String, String>> addErrorSourceToList(String source, String message) {
		return addErrorSourceToList(source, message, null);
	}

	/**
	 * This method create the error source object and returns the same to the
	 * caller.
	 * 
	 * @param source  - specifies the source of the error message
	 * @param message - specifies the details of the error
	 * @return
	 */
	private Map<String, String> createErrorSource(String source, String message) {
		Map<String, String> errorSource = new HashMap<>();
		errorSource.put(ResponseKey.source.toString(), source);
		errorSource.put(ResponseKey.message.toString(), source);
		return errorSource;
	}

	/**
	 * This method prepares the exception object and return the same to the caller.
	 * 
	 * @param responseStatus          - specifies the response responseStatus for the request
	 * @param apiResponseCode - specifies the api response code for the request
	 * @param apiName         - specifies the api name for which this response is
	 *                        being sent
	 * @param errors          - specifies the error sources causing this exception
	 * @return
	 */
	private ApplicationException getApplicationException(HttpStatus httpStatus, Status status, ApiResponseCode apiResponseCode, String apiName,
			List<Map<String, String>> errors) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put(ResponseKey.responseTime.toString(), LocalDateTime.now());
		errorResponse.put(ResponseKey.status.toString(), status);
		errorResponse.put(ResponseKey.apiRespCode.toString(), apiResponseCode.getApiRespCode());
		errorResponse.put(ResponseKey.apiName.toString(), apiName);
		errorResponse.put(ResponseKey.errors.toString(), errors);
		return new ApplicationException(errorResponse, httpStatus);
	}
}
