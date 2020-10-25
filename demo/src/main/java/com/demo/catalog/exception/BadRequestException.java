package com.demo.catalog.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorInfo error;

	/**
	 * @return the error
	 */
	public ErrorInfo getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(ErrorInfo error) {
		this.error = error;
	}

	/**
	 * @param error
	 */
	public BadRequestException(ErrorInfo error) {
		super();
		this.error = error;
	}

}
