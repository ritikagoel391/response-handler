package com.example.response.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;

/**
 * This class contains the header attributes that are to be sent as a part of
 * success response.
 * 
 * @author ritika.goel
 *
 */
public class ApplicationResponse<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1715864978199998776L;

	LocalDateTime responseTime;

	Status responseStatus;

	ApiResponseCode apiResponseCode;

	String apiName;

	T response;

	public ApplicationResponse(LocalDateTime responseTime, Status status, ApiResponseCode apiRespCode, String apiName,
			T response) {
		this.responseTime = responseTime;
		this.responseStatus = status;
		this.apiResponseCode = apiRespCode;
		this.apiName = apiName;
		this.response = response;
	}

	public LocalDateTime getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(LocalDateTime responseTime) {
		this.responseTime = responseTime;
	}

	public Status getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Status responseStatus) {
		this.responseStatus = responseStatus;
	}

	public ApiResponseCode getApiResponseCode() {
		return apiResponseCode;
	}

	public void setApiResponseCode(ApiResponseCode apiResponseCode) {
		this.apiResponseCode = apiResponseCode;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
}
