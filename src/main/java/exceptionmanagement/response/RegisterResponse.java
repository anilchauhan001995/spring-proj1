package exceptionmanagement.response;

import org.springframework.http.ResponseEntity;

public class RegisterResponse extends BaseResponse {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
