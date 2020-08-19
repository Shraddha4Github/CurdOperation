package com.shraddha.curdoperation.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shraddha.curdoperation.constant.AppConstant;
import com.shraddha.curdoperation.dto.EmployeeDto;
import com.shraddha.curdoperation.dto.ResponseDto;
import com.shraddha.curdoperation.service.EmployeeService;


@RestController
@RequestMapping("/empolyees")
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 
	 * @param employeeDto
	 * @return
	 */
	@PostMapping(" ")
	public ResponseEntity<ResponseDto> save(@Valid @RequestBody EmployeeDto employeeDto){
		
		ResponseDto responseDto = new ResponseDto();
		employeeService.saveEmployee(employeeDto);
		
		responseDto.setResponseMessage(AppConstant.EMPLOYEE_REGISTER);
		responseDto.setStatus(HttpStatus.CREATED.value());
		
		logger.info(AppConstant.EMPLOYEE_REGISTER);
		return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
	}
	/**
	 * 
	 * @return
	 */
	@GetMapping(" ")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> empDtos = employeeService.getAllEmployee();
		
		return new ResponseEntity<>(empDtos, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id
	 * @param employeeDto
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDto> update (@PathVariable Integer id ,@RequestBody EmployeeDto employeeDto){
		 
		logger.info(AppConstant.EMPLOYEE_UPDATED_SUCCESS);
		return employeeService.updateEmployee(id, employeeDto);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto>  delete (Integer id){
		 
		logger.info(AppConstant.EMPLOYEE_DELETED_SUCCESS);
		return employeeService.deleteEmployee(id);
	}
	
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeDto>> searchEmployee (@RequestParam String userName){
		
		List<EmployeeDto> employeeDtoList = employeeService.searchEmployeeByName(userName);
		return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
	}
}
