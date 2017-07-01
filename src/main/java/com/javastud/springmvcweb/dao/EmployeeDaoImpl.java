package com.javastud.springmvcweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Department;
import com.javastud.springmvcweb.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertUpdate(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> empList = (List<Employee>) criteria.list();
		/**
		 * Address , PhoneNos are of fetchType Lazy. that means they should be
		 * fetched early(eager) before we pass them to JSP. Departement is
		 * already Eager so thats already fetched from db.
		 */
		for (Employee emp : empList) {
			Hibernate.initialize(emp.getAddress());
			Hibernate.initialize(emp.getPhoneNos());
		}
		return empList;
	}

	@Override
	@Transactional
	public Employee get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, id);
		// Make all fetch type Lazy to Eager.
		Hibernate.initialize(emp.getAddress());
		Hibernate.initialize(emp.getPhoneNos());
		return emp;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		/**
		 * If employee -> department fetchtype is Lazy , hibernate does not 
		 * delete child object, wired issue though.
		 * Trick: if EAGER, dissociate employee with department so that
		 * it will not delete departent records but only emp_dept table relation.
		 */
		for(Department dept : employee.getDepartments()){
			dept.setEmployees(null);
		}
		employee.setDepartments(null);
		session.delete(employee);
	}

}
