package exceptionmanagement.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exceptionmanagement.entities.UserProfile;
import exceptionmanagement.entities.Users;
import exceptionmanagement.exception.ApiException;
import exceptionmanagement.repo.UsersRepo;
import exceptionmanagement.request.RegisterRequest;
import exceptionmanagement.response.RegisterResponse;

@Service
public class Registerhandler extends BaseHandler<RequestEntity<? extends RegisterRequest>, ResponseEntity<? extends RegisterResponse>>{

	@Autowired
	private UsersRepo userRepo;
	
	@Override
	public void validateHeader(RequestEntity<? extends RegisterRequest> request) throws ApiException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(RequestEntity<? extends RegisterRequest> request) throws ApiException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<? extends RegisterResponse> handle(RequestEntity<? extends RegisterRequest> request)
			throws ApiException, Exception {
		
		Users user = new Users(request.getBody().getUsername(), request.getBody().getPassword());
		
		UserProfile profile = new UserProfile();
		profile.setFirstName(request.getBody().getFirstName());
		profile.setLastname(request.getBody().getLastName());
		Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getBody().getDateOfBirth());
		profile.setDateOfBirth(d1);
		profile.setGender(request.getBody().getGender());
		profile.setAddress1(request.getBody().getAddress1());
		profile.setAddress2(request.getBody().getAddress2());
		profile.setCity(request.getBody().getCity());
		profile.setSteet(request.getBody().getSteet());
		profile.setState(request.getBody().getState());
		profile.setCountry(request.getBody().getCountry());
		profile.setPhoneNumber(request.getBody().getPhoneNumber());
		profile.setZipCode(request.getBody().getZipCode());
		
		user.setUserProfile(profile);
		
		profile.setUser(user);
		Users u = userRepo.save(user);
		RegisterResponse response = new RegisterResponse();
		if (u != null) {
			response.setErrors(null);
			response.setUserName(u.getUsername());
			return new ResponseEntity<RegisterResponse>(response, HttpStatus.OK);
		}
		return new ResponseEntity<RegisterResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<? extends RegisterResponse> createErrorResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<? extends RegisterResponse> createErrorResponse(ApiException e) {
		// TODO Auto-generated method stub
		return null;
	}

}
