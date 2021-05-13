package com.test.SpringBootwithHibernate.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.SpringBootwithHibernate.service.SpringService;
import com.test.SpringBottwithHibernate.Entity.Country;
import com.test.SpringBottwithHibernate.Entity.Employee;
import com.test.SpringBottwithHibernate.Entity.EmployeeTable;


@RestController
@CrossOrigin
public class SpringController {

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	SpringService springservice;
	
	
	@GetMapping("/getallemployee")
	public List<Employee> getAllemployee()
	{
		List<Employee> list=springservice.getAllemployee();
		return list;
	}
	
	
	
	
	@GetMapping("/getallemployeebyid/{id}")
	public List<Employee> getemployeebyid(@PathVariable int id)
	{
		List<Employee> list=springservice.getemployeebyid(id);
		return list;
	}
	
	@GetMapping("/getallemployeebyname/{name}")
	public List<Employee> getemployeebyname(@PathVariable String name)
	{
		List<Employee> list=springservice.getemployeebyname(name);
		return list;
	}
	
	@GetMapping("/getallemployeebystatus/{status}")
	public List<Employee> getemployeebystatus(@PathVariable String status)
	{
		List<Employee> list=springservice.getemployeebystatus(status);
		return list;
	}
	@GetMapping("/getallemployeebytype/{type}")
	public List<Employee> getemployeebytype(@PathVariable String type)
	{
		List<Employee> list=springservice.getemployeebytype(type);
		return list;
	}
	/*
	@GetMapping("/getallemployeefromemployeetable")
	public ResponseEntity<List<EmployeeTable>> getemployeetable()
	{
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(EmployeeTable
				.class);
		List<EmployeeTable> listemp=criteria.list();

		System.out.println(listemp);
		return new ResponseEntity<List<EmployeeTable>>(listemp,HttpStatus.OK);
		
	}
	*/
	
	
	//api1 get all employee 
	@GetMapping("/getallemployeefromemployeetable")
	public List<EmployeeTable> getemployeetable()
	{
		List<EmployeeTable> listemp=springservice.getemployeetable();
		return listemp;
		
		
	}
	
	
	//api2 get all employee by name 
	@GetMapping("/employeetablebyname/{name}")
	public List<EmployeeTable> getemployeetablebyname(@PathVariable String name)
	{
		
		List<EmployeeTable> listemp=springservice.getemployeetablebyname(name);
		return listemp;
		
	}
	
	//api3 gety all employee by id
	
	@GetMapping("/getemployeetablebyid/{id}")
	public List<EmployeeTable> getemployeetablebyid(@PathVariable("id") int id)
	{
		List<EmployeeTable> listemp=springservice.getemployeetablebyid(id);
		return listemp;
		
	
	}
	//api 4 get employee by status
	@GetMapping("/getemployeetablebystatus/{status}")
	public List<EmployeeTable> getemployeetablebystatus(@PathVariable("status") String status)
	{
		List<EmployeeTable> listemp=springservice.getemployeetablebystatus(status);
		return listemp;
		
	}
	
	
	//api 5 add employee into table
	@PostMapping("/addemployeetable")
	public String addemployee(@RequestBody EmployeeTable emptable)
	{
		
		String msg=springservice.addemployee(emptable);
		return msg;
		
	}
	
	
	//api 6 add country into table
	@PostMapping("/addcountry")
	public String addCountry(@RequestBody Country country)
	{
		String msg=springservice.addCountry(country);
		
		return msg;
		
	}
	
	//api 7 update country name
	@PutMapping("/updatecountryname")
	public String updateCountry(@RequestBody Country country) {
		
		String msg=springservice.updateCountry(country);
		return msg;
		
	}
	
	//api 8 delete country by name
	@RequestMapping(value="/deletecountrybyname/{cname}", method=RequestMethod.DELETE)
	public String deletecountrybyname(@PathVariable("cname") String cname)
	{

		String msg=springservice.updateCountry(cname);
		return msg;
		
	}
	
	
	//api 9 delete employee by id
	
	@DeleteMapping("/deleteemployeetable/{id}")
	public String deleteemployeetablebyid(@PathVariable("id") int id)
	{
		String msg=springservice.deleteemployeetablebyid(id);
		return msg;
		
		
	}
	
	
	//api 10 delete country by id
	@RequestMapping(value="/deletecountrybyid/{cid}", method=RequestMethod.DELETE)
	public String deletecountrybyid(@PathVariable("cid") int cid)
	{

		String msg=springservice.deletecountrybyid(cid);
		return msg;
		
	}
	
	//api 11 get country by id 
	@GetMapping("/getcountry/{id}")
	public List<Country> getCountrybyid(@PathVariable("id") int id)
	{
		List<Country> listcountry=springservice.getCountrybyid(id);
		return listcountry;
		
	
		
	}
	
	/*
	
	@PostMapping("/addemployee")
	public String addemployee(@RequestBody Employee emp)
	{
		System.out.println("in addemployee method");
		System.out.println(emp);
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println(emp.getEmpId());
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpAge());
		
		System.out.println(emp.getStatus());
		
		Employee emp1=new Employee();
		emp1.setEmpId(emp.getEmpId());
		emp1.setEmpName(emp.getEmpName());
		emp1.setEmpAge(emp.getEmpAge());
		emp1.setStatus(emp.getStatus());
		
		
		session.save(emp1);
		transaction.commit();
		return "Data inserted successfully!";
	}
	
	
	*/
	
	
	
	
	
	
	
}
