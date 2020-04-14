package com.example.constants;

/**
 * This enum contains the response codes to be sent at API level. More values
 * can be added here going forward as per different scenarios encountered within
 * the application.
 * 
 * @author ritika.goel
 *
 */
public enum ApiResponseCode {
	INTERNAL_SERVER_ERROR(5000);

	private Integer apiRespCode;
	
	ApiResponseCode(Integer apiRespCode) {
		this.apiRespCode = apiRespCode;
	}

	/**
	 * This method acts as a getter for apiRespCode instance variable.
	 * 
	 * @return This returns the api response code. 
	 */
	public Integer getApiRespCode() {
		return apiRespCode;
	}
}
