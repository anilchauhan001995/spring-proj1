package exceptionmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exceptionmanagement.handler.BaseHandler;
import exceptionmanagement.handler.LoginHandler;
import exceptionmanagement.handler.Registerhandler;
import exceptionmanagement.request.BaseRequest;
import exceptionmanagement.request.LoginRequest;
import exceptionmanagement.request.RegisterRequest;
import exceptionmanagement.response.RegisterResponse;

@RestController
@RequestMapping(method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
public class UsersController {
	
	@Autowired
	private Registerhandler registerhandler;
	
	/*
	 * public void login(RequestEntity<LoginRequest> request) {
	 * loginHandler.execute(request); }
	 */
	
	@RequestMapping("/register")
	public ResponseEntity<RegisterResponse> register(RequestEntity<RegisterRequest> request) {
		return (ResponseEntity<RegisterResponse>) registerhandler.execute(request);
	}
	
}
