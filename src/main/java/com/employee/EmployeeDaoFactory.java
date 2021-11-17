package com.employee;

public class EmployeeDaoFactory {
	private static EmployeeDao employeeDao;
	public static EmployeeDao getEmployeeDao() {
		if (employeeDao == null)
			employeeDao = new EmployeeDaoImpl();
		return employeeDao;
	}
}
