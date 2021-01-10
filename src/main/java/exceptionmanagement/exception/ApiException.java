package exceptionmanagement.exception;

import exceptionmanagement.message.ApiErrorCodes;

public class ApiException extends Exception {
	
	private static final int serialVerionUID =1;
	
	private String code;
	private String message;
	private ApiErrorCodes errorCode;
	
	public ApiException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ApiException(ApiErrorCodes e) {
		this.code = e.getCode();
		this.message = e.getMessage();
		this.errorCode = e;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ApiErrorCodes errorCode) {
		this.errorCode = errorCode;
	}
}
