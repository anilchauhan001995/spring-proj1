package exceptionmanagement.handler;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import exceptionmanagement.exception.ApiException;
import exceptionmanagement.message.ApiErrorCodes;
import exceptionmanagement.request.BaseRequest;
import exceptionmanagement.response.BaseResponse;
import exceptionmanagement.response.element.Error;
public abstract class BaseHandler<U extends RequestEntity<? extends BaseRequest>, T extends ResponseEntity<? extends BaseResponse>> {
	
	public T execute(U request) {
		
		try {
			
			validateHeader(request);
			validate(request);
			return handle(request);
		} catch(ApiException api) {
			T t = createErrorResponse(api);
			t.getBody().addErrors(new Error(api));
			return t;
			
		} catch (Exception e) {
			T t = createErrorResponse();
			ApiException ex = new ApiException(ApiErrorCodes.M001);
			t.getBody().addErrors(new Error(ex));
			return t;
		}
	}
	
	public abstract void validateHeader(U request) throws ApiException;
	
	public abstract void validate(U request) throws ApiException;
	
	public abstract T handle(U request) throws ApiException, Exception;
	
	public abstract T createErrorResponse();
	
	public abstract T createErrorResponse(ApiException e);

}
