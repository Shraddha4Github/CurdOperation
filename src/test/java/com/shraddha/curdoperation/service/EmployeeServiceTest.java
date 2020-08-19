package com.shraddha.curdoperation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import com.shraddha.curdoperation.dto.EmployeeDto;
import com.shraddha.curdoperation.dto.ResponseDto;
import com.shraddha.curdoperation.entity.Employee;
import com.shraddha.curdoperation.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository empRepository;
	
	/*@Test
	public void testSaveEmployee(){
		Employee employee = new Employee();
		EmployeeDto employeeDto = new EmployeeDto();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		BeanUtils.copyProperties(employee, employeeDto);
		Mockito.when(empRepository.save(employee)).thenReturn(employee);
		employee = employeeService.saveEmployee(employeeDto);
		
		Assert.assertNotNull(employee);
	}
	
	
	@Test
	public void testGetAllEmployee(){
		
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
		
		Mockito.when(empRepository.findAll(Sort.by(Sort.Direction.DESC, "userName"))).thenReturn(employeeList);
		employeeDtoList = employeeService.getAllEmployee();
		
		Assert.assertNotNull(employeeDtoList);
	}
	
	@Test
	public void testUpdateEmployee(){
		Employee employee = new Employee();
		EmployeeDto employeeDto = new EmployeeDto();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		BeanUtils.copyProperties(employee, employeeDto);
		Mockito.when(empRepository.findById(1)).thenReturn(Optional.of(employee));
		Mockito.when(empRepository.save(employee)).thenReturn(employee);
		
		ResponseEntity<ResponseDto> updateEmployee = employeeService.updateEmployee(1, employeeDto);
		
		Assert.assertNotNull(updateEmployee);
	}
	
	@Test
	public void testsearchEmployeeByName(){
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		employeeList.add(employee);
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		List<EmployeeDto> employeeDtoList = new ArrayList();
		employeeDtoList.add(employeeDto);
		
		BeanUtils.copyProperties(employee, employeeDto);
		Mockito.when(empRepository.findByUserNameContains("Mona")).thenReturn(employeeList);
		employeeDtoList = mployeeService.searchEmployeeByName("Mona");
		
		Assert.assertNotNull(employeeDtoList);
	}
	
	@Test
	public void testDeleteEmployee(){
		Employee employee = new Employee();
		EmployeeDto employeeDto = new EmployeeDto();
		employee.setId(1);
		employee.setEmail("mona@m.com");
		employee.setUserName("Mona");
		BeanUtils.copyProperties(employee, employeeDto);
		//Mockito.when(empRepository.delete(employee));
		
		Assert.assertNotNull(employee);
	}*/
}
