package com.genix.addressbook.exception;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * 
 * Runtime Exception handler for Business Validations.
 */
public class ValidationFailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationFailException() {
		super();
	}

	public ValidationFailException(String message) {
		super(message);
	}

	public ValidationFailException(Throwable throwable) {
		super(throwable);
	}

	public ValidationFailException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
