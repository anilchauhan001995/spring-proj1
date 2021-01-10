package exceptionmanagement.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exceptionmanagement.exception.ApiException;
import exceptionmanagement.request.LoginRequest;
import exceptionmanagement.response.LoginResponse;

@Service
public class LoginHandler extends BaseHandler<RequestEntity<? extends LoginRequest>, ResponseEntity<? extends LoginResponse>> {

	
	@Override
	public void validateHeader(RequestEntity<? extends LoginRequest> request) throws ApiException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(RequestEntity<? extends LoginRequest> request) throws ApiException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<? extends LoginResponse> handle(RequestEntity<? extends LoginRequest> request)
			throws ApiException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<? extends LoginResponse> createErrorResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<? extends LoginResponse> createErrorResponse(ApiException e) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
