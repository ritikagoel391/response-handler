package com.example.response;

import java.time.LocalDateTime;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;
import com.example.response.model.ApplicationResponse;

/**
 * This is a utility class and contains method to handle success scenario
 * response.
 * 
 * @author ritika.goel
 *
 */
public class ResponseUtil {
	/**
	 * This method is used to wrap the controller response into the standard
	 * application response.
	 * 
	 * @param <T>
	 * @param apiName
	 * @param response
	 * @return
	 */
	public static <T> ApplicationResponse<T> createApplicationResponse(String apiName, T response) {
		return new ApplicationResponse<>(LocalDateTime.now(), Status.SUCCESS, ApiResponseCode.SUCCESS, apiName,
				response);
	}

	private ResponseUtil() {
	}
}
