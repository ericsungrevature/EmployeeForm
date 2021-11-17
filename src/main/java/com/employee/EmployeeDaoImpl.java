package com.employee;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings({ "deprecation", "unchecked" })
public class EmployeeDaoImpl implements EmployeeDao {

	Configuration cfg;
	SessionFactory factory;

	public EmployeeDaoImpl() {
		cfg = new Configuration();
		cfg.configure("com/employee/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	@Override
	public void addEmployee(Employee e) throws SQLException {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e);
		tr.commit();
		session.close();
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		int id = getEmployee(e.getName()).getId();
		e.setId(id);
		session.update(e);
		tr.commit();
		session.close();
	}

	@Override
	public void deleteEmployee(Employee e) throws SQLException {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		int id = getEmployee(e.getName()).getId();
		e.setId(id);
		session.delete(e);
		tr.commit();
		session.close();
	}

	@Override
	public Employee getEmployee(String name) throws SQLException {
		Employee e = new Employee();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("name", name));
		List<Employee> results = cr.list();
		if (results != null) {
			e = results.get(0);
		}
		
		tr.commit();
		session.close();
		return e;
	}

	@Override
	public List<Employee> listEmployees() throws SQLException {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> results = query.getResultList();
		tr.commit();
		session.close();
		return results;
	}

}
