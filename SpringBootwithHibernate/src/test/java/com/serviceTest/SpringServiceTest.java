package com.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import com.test.SpringBootwithHibernate.dao.SpringDao;
import com.test.SpringBootwithHibernate.service.SpringService;
import com.test.SpringBottwithHibernate.Entity.Employee;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SpringServiceTest {

	@InjectMocks
	SpringService service;
	
	@Mock
	SpringDao springdao;
	
	
	@Test // case for retirerd typr
	public void getemployeebytypeTest() {
		
		List<Employee> list = new ArrayList<Employee>();
		when(springdao.getemployeebytype()).thenReturn(list);
		 List<Employee> result = 	service.getemployeebytype("retired");
		
		 Assert.assertNotNull(result);
		 
	}
	@Test
	public void getemployeebytypeTest1() {
		
		List<Employee> list = new ArrayList<Employee>();
		when(springdao.getemployeebytypeworking()).thenReturn(list);
		 List<Employee> result = 	service.getemployeebytype("working");
		
		 Assert.assertNotNull(result);
	}
	@Test
	public void getemployeebytypeTest2() {
		
		
		
		 List<Employee> result = 	service.getemployeebytype("Sagar");
		
		 Assert.assertNull(result);
	}
	
	
}
