package com.employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
	void addEmployee(Employee e) throws SQLException;
	void updateEmployee(Employee e) throws SQLException;
	void deleteEmployee(Employee e) throws SQLException;
	Employee getEmployee(String name) throws SQLException;
	List<Employee> listEmployees() throws SQLException;
}
