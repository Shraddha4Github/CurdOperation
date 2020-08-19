package com.shraddha.curdoperation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shraddha.curdoperation.constant.AppConstant;
import com.shraddha.curdoperation.dto.EmployeeDto;
import com.shraddha.curdoperation.dto.ResponseDto;
import com.shraddha.curdoperation.entity.Employee;
import com.shraddha.curdoperation.exception.EmployeeNotFoundException;
import com.shraddha.curdoperation.repository.EmployeeRepository;


@Service
public class EmployeeService {

	
	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepository empRepository;
	
	/**
	 * This method use to save employee details in database
	 * @param employeeDto
	 * @return Employee
	 */
	public Employee saveEmployee(EmployeeDto employeeDto){
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		empRepository.save(employee);
		logger.info(AppConstant.EMPLOYEE_REGISTER);
		return employee;
	}
	
	
	/**
	 * This method use to get all employee details from database
	 * @return employeeDtoList
	 */
	public List<EmployeeDto> getAllEmployee() {
		
			List<Employee> employeeList = empRepository.findAll(Sort.by(Sort.Direction.DESC, "userName"));
			List<EmployeeDto> employeeDtoList = new ArrayList();
			
			employeeList.stream().forEach(employee->
			{
				EmployeeDto empDto = new EmployeeDto();
				BeanUtils.copyProperties(employee, empDto);
				employeeDtoList.add(empDto);
			});
			return employeeDtoList;
	}
	
	/**
	 * This method use to Update employee for given employee id
	 * @param id
	 * @param employeeDto
	 * @return ResponseEntity
	 */
	public ResponseEntity<ResponseDto> updateEmployee(Integer id, EmployeeDto employeeDto){
		
		ResponseDto responseDto = new ResponseDto();
		Optional<Employee> employeeOp =  empRepository.findById(id);
		
		if(employeeOp.isPresent()){
			
			Employee employee = employeeOp.get();
			employee.setId(id);
			BeanUtils.copyProperties(employeeDto, employee);
			empRepository.save(employee);
			
			responseDto.setResponseMessage(AppConstant.EMPLOYEE_UPDATED_SUCCESS);
			responseDto.setStatus(HttpStatus.OK.value());
			logger.info(AppConstant.EMPLOYEE_UPDATED_SUCCESS);
			return new ResponseEntity<>(responseDto,HttpStatus.OK);
		}
		else {
			
			throw new EmployeeNotFoundException(id.toString());
		}
		
	}
	
	
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public List<EmployeeDto> searchEmployeeByName(String username){
		List<EmployeeDto> employeeDtoList = new ArrayList();
		List<Employee> employeeList = empRepository.findByUserNameContains(username);
		if(!employeeList.isEmpty()){
			employeeList.stream().forEach(employee -> {
			EmployeeDto employeeDto = new EmployeeDto();
		
			BeanUtils.copyProperties(employee, employeeDto);
			employeeDtoList.add(employeeDto);
			}		);
		}else {
			throw new EmployeeNotFoundException(username);
		}
		return employeeDtoList;
	}
	
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ResponseEntity<ResponseDto> deleteEmployee(Integer id){
		
		ResponseDto responseDto = new ResponseDto();
		Optional<Employee> emp =  empRepository.findById(id);
		if(emp.isPresent()){
			empRepository.delete(emp.get());
			
			responseDto.setResponseMessage(AppConstant.EMPLOYEE_DELETED_SUCCESS);
			responseDto.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<>(responseDto ,HttpStatus.OK);	
		}
		else {
			throw new EmployeeNotFoundException(id.toString());
		}
		
	}
	

	
	
	
	
}
