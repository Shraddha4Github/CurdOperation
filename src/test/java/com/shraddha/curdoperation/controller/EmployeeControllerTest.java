package com.shraddha.curdoperation.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shraddha.curdoperation.constant.AppConstant;
import com.shraddha.curdoperation.dto.EmployeeDto;
import com.shraddha.curdoperation.dto.ResponseDto;
import com.shraddha.curdoperation.entity.Employee;
import com.shraddha.curdoperation.service.EmployeeService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	
	
	@Test
	public void testSave (){
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		Mockito.when(employeeService.saveEmployee(employeeDto)).thenReturn(employee);
		employeeController.save(employeeDto);
		
	}
	
	@Test
	public void testGetAllEmployees (){
		
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		employeeList.add(employee);
		
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		
		List<EmployeeDto> employeeDtoList = new ArrayList();
		employeeDtoList.add(employeeDto);
		
		Mockito.when(employeeService.getAllEmployee()).thenReturn(employeeDtoList);
		ResponseEntity<List<EmployeeDto>> allEmployees = employeeController.getAllEmployees();
		
		Assert.assertNotNull(allEmployees);
	}
	
	@Test
	public void testUpdate(){
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage(AppConstant.EMPLOYEE_UPDATED_SUCCESS);
		responseDto.setStatus(HttpStatus.OK.value());
		
		ResponseEntity<ResponseDto> responseentity = new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		Mockito.when(employeeService.updateEmployee(1, employee)).thenReturn(responseentity);
		responseentity = employeeController.update(1, employee);
		
		Assert.assertNotNull(responseentity);
	}
	
	@Test
	public void testDelete(){
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseMessage(AppConstant.EMPLOYEE_UPDATED_SUCCESS);
		responseDto.setStatus(HttpStatus.OK.value());
		
		ResponseEntity<ResponseDto> responseentity = new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		Mockito.when(employeeService.deleteEmployee(1)).thenReturn(responseentity);
		responseentity = employeeController.delete(1);
		
		Assert.assertNotNull(responseentity);
	}
	
	@Test
	public void testsearchEmployee(){
		
		EmployeeDto employee = new EmployeeDto();
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		List<EmployeeDto> employeeDtoList = new ArrayList();
		employeeDtoList.add(employee);
		
		Mockito.when(employeeService.searchEmployeeByName("Mona")).thenReturn(employeeDtoList);
		ResponseEntity<List<EmployeeDto>> responseEntity = employeeController.searchEmployee("Mona");
		
		Assert.assertNotNull(responseEntity);
	}
	
	
}
