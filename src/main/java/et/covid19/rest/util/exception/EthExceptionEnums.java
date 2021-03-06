package et.covid19.rest.util.exception;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;

/**
 * a supplier of custom exceptions
 */
public enum EthExceptionEnums implements Supplier<EthException> {

	VALIDATION_EXCEPTION(new EthException(HttpStatus.BAD_REQUEST , 400001, "Something went wrong, please contact system administrator.")),

	USER_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404001, "User not found, please try again!")),
	CASE_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404002, "Case not found, please try again!")),
	CONSTANT_NOT_FOUND(new EthException(HttpStatus.NOT_FOUND , 404003, "Case not found, please try again!")),
	
	USERNAME_OR_EMAIL_INCORECT(new EthException(HttpStatus.UNAUTHORIZED , 401001, "User name or email incorrect!")),
	AUTHENTICATION_REQUIRED(new EthException(HttpStatus.UNAUTHORIZED , 401002, "Authentication is requred, please try again!")),
	INSUFFICENT_PERMISSION(new EthException(HttpStatus.UNAUTHORIZED , 401003, "Insufficient permission!")),
	
	UNHANDLED_EXCEPTION(new EthException(HttpStatus.INTERNAL_SERVER_ERROR , 500001, "Unhandled exception has occured."));
	
	
	/// ======   ======///
	private EthException e;
	
	/**
	 * needed to put exceptions inside the enums
	 * @param ex
	 */
	private EthExceptionEnums(EthException ex) {
		this.e = ex;
	}
	
	public void message(String message){
		e.setMessage(message);
	}
	/**
	 * gets the EthException instance triggered by the enums
	 * @param e
	 * @return EthException of defined enums
	 */
	@Override
	public EthException get() {
		return e;
	}
}
