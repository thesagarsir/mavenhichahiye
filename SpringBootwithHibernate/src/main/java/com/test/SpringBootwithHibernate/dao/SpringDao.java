package com.test.SpringBootwithHibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.test.SpringBottwithHibernate.Entity.Country;
import com.test.SpringBottwithHibernate.Entity.Employee;
import com.test.SpringBottwithHibernate.Entity.EmployeeTable;

@Repository
public class SpringDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public List<Employee> getAllemployee() {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		// select * from employee;
		//executeQuery();
		
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> emp_list=(List<Employee>)criteria.list();
		
		return emp_list;
	}

	public List<Employee> getemployeebyid(int emp_id) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empId", emp_id));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
	}

	public List<Employee> getemployeebyname(String name) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empName", name));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
		
		
		
	}

	public List<Employee> getemployeebystatus(String status) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		
		//sessionfactory.getCurrentSession().load(Employee.class, emp_id);
		Criteria criteria=session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.eq("status", status));
		
		List<Employee> list_emp=criteria.list();
		
		return list_emp;
	}

	public List<Employee> getemployeebytype() {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		int age=50;
		//Query query=session.createQuery("delete from Account where accountstatus=:status");
		//query.setString("status", "purged");//employee
		Query query=session.createQuery("from Employee where empAge>:age");
		
		query.setInteger("age", age);
		
		List<Employee> emp_list=query.list();
		return emp_list;
	}

	public List<Employee> getemployeebytypeworking() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		int age=50;
		//Query query=session.createQuery("delete from Account where accountstatus=:status");
		//query.setString("status", "purged");
		Query query=session.createQuery("from Employee where empAge<:age");
		query.setInteger("age", age);
		
		List<Employee> emp_list=query.list();
		return emp_list;
	}
	/*
	//   List<Employee>
	public ResponseEntity<List<Employee>> getemployeetable() {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(EmployeeTable.class);
		List<Employee> listemp=criteria.list();
		
		return new ResponseEntity<List<Employee>>(listemp,HttpStatus.OK);
	}
	*/

	//get all employee api1
	public List<EmployeeTable> getemployeetable() {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(EmployeeTable.class);
		List<EmployeeTable> listemp=criteria.list();

		System.out.println(listemp);
		return listemp;
	}

	
	//get all employee by name api2
	public List<EmployeeTable> getemployeetablebyname(String name) {
		
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(EmployeeTable.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<EmployeeTable> listemp=criteria.list();
		
		System.out.println(listemp);
		
		return listemp;
		
	}

	//api3 getemployee by id
	
	public List<EmployeeTable> getemployeetablebyid(int id) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(EmployeeTable.class);
		criteria.add(Restrictions.eq("id", id));
		List<EmployeeTable> listemp=criteria.list();
		return listemp;
	}
	
	//api 4 getemployee by status active & inactive

	public List<EmployeeTable> getemployeetablebystatus(String status) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(EmployeeTable.class);
		criteria.add(Restrictions.eq("status", status));
		List<EmployeeTable> listemp=criteria.list();
		
		return listemp;
	}
	
	//api 5 add employee

	public String addemployee(EmployeeTable emptable) {
		
		System.out.println("addemployeetable");
		Country ctr=new Country();
		ctr.setCid(emptable.getCountry().getCid());
		ctr.setCname(emptable.getCountry().getCname());
		
		EmployeeTable emp=new EmployeeTable();
		emp.setId(emptable.getId());
		emp.setName(emptable.getName());
		emp.setPhoneno(emptable.getPhoneno());
		emp.setStatus(emptable.getStatus());
		emp.setDepartmentit(emptable.getDepartmentit());
		emp.setCreatedby(emptable.getCreatedby());
		emp.setCreateddtm(emptable.getCreateddtm());
		emp.setUppdatedby(emptable.getUppdatedby());
		emp.setUpdateddtm(emptable.getUpdateddtm());
		emp.setCountry(ctr);
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(emp);
		transaction.commit();
		
		return "Employee inserted successfully"; 
	}

	
	//api 6 add country
	public String addCountry(Country country) {

		
		System.out.println("Add country method");
		System.out.println(country);
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		
		//String cname=country.getCname();

		Country country1=new Country();
		country1.setCname(country.getCname());
		//country1.setCid(country.getCid());
		
		
		session.save(country1);
		
		
		transaction.commit();
		System.out.println("Data inserted successfully!");
		return "Data inserted successfully!";
		
		
	}
	//api 7 update country
	public String updateCountry(Country country) {
		
		System.out.println("connection by controller");
		Session session=sessionfactory.openSession();
		Transaction tr= session.beginTransaction();
		
		//update Country set cname='China' where cid=3;
		Query query = session.createQuery("update Country set cname=:name where cid=:id");
		query.setParameter("name", country.getCname());
		query.setParameter("id", country.getCid());
		query.executeUpdate();
		tr.commit();
		System.out.println("record updated");
		return "Country Updated Successfully!";
	}
	
	//api 8 delete country by cname

	public String updateCountry(String cname) {
		
		System.out.println(cname);
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Country country=new Country();
		country=session.get(Country.class,cname);
	
		session.delete(country);
		transaction.commit();
		
		return "Country deleted successfully!";
		
		
	}

	//api 9 delete employee by id
	public String deleteemployeetablebyid(int id) {

		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("delete from EmployeeTable where id=:id ");
		query.setParameter("id", id);
		int i=query.executeUpdate();
		transaction.commit();
		
		return "employee deleted successfully!";
		
		
	}
	//api 10 delete country by cid

	public String deletecountrybyid(int cid) {
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("delete from Country where cid=:cid ");
		query.setParameter("cid", cid);
		int i=query.executeUpdate();
		transaction.commit();
		
		return "country deleted successfully!";
		
		
	}

	//api 11 get country by id
	public List<Country> getCountrybyid(int id) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(Country.class);
		
		criteria.add(Restrictions.eq("cid", id));
		
		List<Country> listcountry=criteria.list();
		transaction.commit();
		System.out.println("Data retrieved successfully!"+listcountry);
		return listcountry;
		
	}
}
