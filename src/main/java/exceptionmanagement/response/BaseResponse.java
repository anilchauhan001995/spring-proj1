package exceptionmanagement.response;

import java.util.ArrayList;
import java.util.List;

import exceptionmanagement.response.element.Error;

public class BaseResponse {
	
	List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	public void addErrors(Error error) {
		if (error == null) {
			errors = new ArrayList<>();
		}
		this.errors.add(error);
	}

}
