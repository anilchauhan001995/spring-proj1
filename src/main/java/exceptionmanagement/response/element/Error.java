package exceptionmanagement.response.element;

import exceptionmanagement.exception.ApiException;

public class Error {
	private String code;
	private String message;
	
	public Error() {
	}
	
	public Error(ApiException e) {
		this.code = e.getCode();
		this.message = e.getMessage();
	}
	public Error(String code, String message) {
		super();
		this.code = code;
		this.message = message;
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
	
	
}
