package com.shraddha.curdoperation.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.shraddha.curdoperation.constant.AppConstant;


@ControllerAdvice
public class GlobalExceptionHandler  {

	/**
	 * to handle null pointer exception
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> nullPointerException(NullPointerException ex, WebRequest wr) {
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put(AppConstant.STATUS_CODE, AppConstant.STATUS_CODE_VALUE_FORNOTFOUND);
		return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
	}

	/**
	 * to handle null general exception
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> generalException(Exception ex, WebRequest wr) {
		Map<String, Object> responseMap = new LinkedHashMap<>();
		responseMap.put(AppConstant.STATUS_CODE, AppConstant.STATUS_CODE_VALUE_FORNOTFOUND);
		responseMap.put(AppConstant.STATUS_MESSAGE, AppConstant.SOMETHINGWRONG_MESSAGE);
		return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
	}

	/**
	 * to handle user Not found exception
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put(AppConstant.STATUS_CODE, AppConstant.STATUS_CODE_VALUE_FORNOTFOUND);
		body.put(AppConstant.STATUS_MESSAGE, AppConstant.EMPLOYEE_NOT_FOUND);
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	/**
	 * 
	 * @param ex
	 * @param re
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object>  customValidationErrorHandling(MethodArgumentNotValidException ex , WebRequest re){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("Status", LocalDateTime.now());
		body.put("cause", ex.getBindingResult().getFieldError().getDefaultMessage());
		body.put("message", "Validation Error");
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}
}
