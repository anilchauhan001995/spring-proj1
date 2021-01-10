package exceptionmanagement.message;

public enum ApiErrorCodes {
	
	M001("M001", "Common Exception"),
	M002("M002", "Session is Expired"),
	M003("M003", "session is Invalid"),
	M004("M004", "The Inputs can not be authenticated"),
	M005("M005", "Too Many request");
	
	ApiErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private ApiErrorCodes(int httpErrorType, String code, String message) {
		this.httpErrorType = httpErrorType;
		this.code = code;
		this.message = message;
	}
	
	private int httpErrorType;
	private String code;
	private String message;
	
	public int getHttpErrorType() {
		return httpErrorType;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
