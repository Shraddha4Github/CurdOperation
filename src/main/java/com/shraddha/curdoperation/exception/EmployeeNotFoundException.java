package com.shraddha.curdoperation.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(String employeeId) {
		
		super(String.format("Employee %s not found",employeeId));
	}
}
