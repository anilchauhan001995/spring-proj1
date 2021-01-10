package exceptionmanagement.message;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpStatus;

public class ApiErrorCodesToHttpStatusmapper {
	
	private static Set<ApiErrorCodes> serverErrorCode;
	private static Set<ApiErrorCodes> clientErrorCodeBadRequests;
	private static Set<ApiErrorCodes> clientErrorCodeToManyRequests;
	private static Set<ApiErrorCodes> clientErroCodeUnAuthorized;
	
	private static Map<HttpStatus, Set<ApiErrorCodes>> httpApiErrorCodeMap;
	
	static {
		httpApiErrorCodeMap = new HashMap<>();
		mapServerErrorCode();
		mapBadRequestsCode();
		mapToManyRequestsCode();
		mapUnAuthorizedCode();
	}
	
	public static HttpStatus getHttpStatusForApiErrorCode(ApiErrorCodes ac) {
		
		Set<Entry<HttpStatus, Set<ApiErrorCodes>>> httpEntrySet = httpApiErrorCodeMap.entrySet();
		HttpApiError httpApiError = retriveHttpstatusErrorCode(httpEntrySet, ac);
		return httpApiError.getHttpStatus();
	}
	
	public static void mapServerErrorCode() {
		Set<ApiErrorCodes> errors = new HashSet<>();
		errors.add(ApiErrorCodes.M001);
		httpApiErrorCodeMap.put(HttpStatus.INTERNAL_SERVER_ERROR, errors);
	}
	
	public static void mapBadRequestsCode() {
		Set<ApiErrorCodes> errors = new HashSet<>();
		errors.add(ApiErrorCodes.M002);
		errors.add(ApiErrorCodes.M003);
		httpApiErrorCodeMap.put(HttpStatus.BAD_REQUEST, errors);
	}
	
	public static void mapToManyRequestsCode() {
		Set<ApiErrorCodes> errors = new HashSet<>();
		errors.add(ApiErrorCodes.M005);
		httpApiErrorCodeMap.put(HttpStatus.TOO_MANY_REQUESTS, errors);
	}
	
	public static void mapUnAuthorizedCode() {
		Set<ApiErrorCodes> errors = new HashSet<>();
		errors.add(ApiErrorCodes.M004);
		httpApiErrorCodeMap.put(HttpStatus.UNAUTHORIZED, errors);
	}
	
	public static HttpApiError retriveHttpstatusErrorCode(Set<Entry<HttpStatus, Set<ApiErrorCodes>>> httpEntrySet, ApiErrorCodes ac) {
		
		HttpApiError httpApiError = null;
		
		for (Entry<HttpStatus, Set<ApiErrorCodes>> entry: httpEntrySet) {
			if (entry.getValue().contains(ac)) {
				httpApiError = HttpApiError.getInstance(entry.getKey(), ac);
			}
		}
		
		return httpApiError;
	}
	
}
