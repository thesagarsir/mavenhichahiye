package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.test.SpringBootwithHibernate.controller.SpringController;
import com.test.SpringBootwithHibernate.service.SpringService;
import com.test.SpringBottwithHibernate.Entity.Employee;
import com.test.SpringBottwithHibernate.Entity.EmployeeTable;

import junit.framework.Assert;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	@InjectMocks
	SpringController con;
	
	@Mock
	SpringService springservice;
	
	@Test
	public void test() {
				List<Employee> list = new ArrayList<Employee>();
		when(springservice.getemployeebyname("Sagar")).thenReturn(list);
		List<Employee> result = con.getemployeebyname("Sagar");
		
		Assert.assertNotNull(result);
		
	}
}
