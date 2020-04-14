package com.example.model;

import java.time.LocalDateTime;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author ritika.goel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseResponse {
	LocalDateTime responseTime;
	Status status;
	ApiResponseCode apiRespCode;
	String apiName;

	public BaseResponse(LocalDateTime responseTime, Status status, ApiResponseCode apiRespCode, String apiName) {
		this.responseTime = responseTime;
		this.status = status;
		this.apiRespCode = apiRespCode;
		this.apiName = apiName;
	}
}
