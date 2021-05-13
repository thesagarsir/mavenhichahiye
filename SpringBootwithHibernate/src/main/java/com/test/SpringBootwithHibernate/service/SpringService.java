package com.test.SpringBootwithHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.SpringBootwithHibernate.dao.SpringDao;
import com.test.SpringBottwithHibernate.Entity.Country;
import com.test.SpringBottwithHibernate.Entity.Employee;
import com.test.SpringBottwithHibernate.Entity.EmployeeTable;

@Service
public class SpringService {

	@Autowired
	SpringDao springdao;
	
	public List<Employee> getAllemployee() {
		
		List<Employee> emplist=springdao.getAllemployee();
		return emplist;
	}

	public List<Employee> getemployeebyid(int id) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebyid(id);
		
		return  emplist;
	}

	public List<Employee> getemployeebyname(String name) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebyname(name);
		
		return  emplist;
		
	}

	public List<Employee> getemployeebystatus(String status) {
		// TODO Auto-generated method stub
		List<Employee> emplist=springdao.getemployeebystatus(status);
		
		return  emplist;
	}

	public List<Employee> getemployeebytype(String type) {
		// TODO Auto-generated method stub
		List<Employee>emplist=null;
		if(type.equals("retired"))
		{
			emplist=springdao.getemployeebytype();
		}
		else if(type.equals("working"))
		{
			emplist=springdao.getemployeebytypeworking();
		}
		else
		{
			emplist=null;
		}
		return emplist;
	}
/*
	public ResponseEntity<List<Employee>> getemployeetable() {
		// TODO Auto-generated method stub
		return springdao.getemployeetable();
	}

	*/
	
	//get all employee api1

	public List<EmployeeTable> getemployeetable() {
		
		List<EmployeeTable> listemp=springdao.getemployeetable();
		
		return listemp;
	}
	//get all employee by name api2
	public List<EmployeeTable> getemployeetablebyname(String name) {
	List<EmployeeTable> listemp=springdao.getemployeetablebyname(name);
		
		return listemp;
	}
	//get all employee by id api 3
	public List<EmployeeTable> getemployeetablebyid(int id) {
		List<EmployeeTable> listemp=springdao.getemployeetablebyid(id);
		
		return listemp;
	}
	//get all employee by status api4
	public List<EmployeeTable> getemployeetablebystatus(String status) {
		List<EmployeeTable> listemp=springdao.getemployeetablebystatus(status);
		
		return listemp;
	}
	//add employee api 5
	public String addemployee(EmployeeTable emptable) {
		String msg=springdao.addemployee(emptable);
		return msg;
	}

	//add country api 6
	
	public String addCountry(Country country) {
		String msg=springdao.addCountry(country);
		return msg;
	}

	
	//update country api 7
	public String updateCountry(Country country) {
		String msg=springdao.updateCountry(country);
		return msg;
	}

	
	//delete country by cname api 8
	
	public String updateCountry(String cname) {
		String msg=springdao.updateCountry(cname);
		return msg;
	}

	//delete employee by id
	public String deleteemployeetablebyid(int id) {
		String msg=springdao.deleteemployeetablebyid(id);
		return msg;
	}

	
	//delete country by cid
	public String deletecountrybyid(int cid) {
		String msg=springdao.deletecountrybyid(cid);
		return msg;
	}

	public List<Country> getCountrybyid(int id) {
		List<Country> listcountry=springdao.getCountrybyid(id);
		
		return listcountry;
	}

	
}
