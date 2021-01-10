package exceptionmanagement.message;

import org.springframework.http.HttpStatus;

public class HttpApiError {
	
	private HttpStatus status;
	private ApiErrorCodes apiErrorCodes;
	
	private HttpApiError(HttpStatus status, ApiErrorCodes errorCodes) {
		this.status = status;
		this.apiErrorCodes = apiErrorCodes;
	}
	
	public static HttpApiError getInstance(HttpStatus status, ApiErrorCodes apiErrorCodes) {
		return new HttpApiError(status, apiErrorCodes);
	}
	
	public HttpStatus getHttpStatus() {
		return status;
	}
}
