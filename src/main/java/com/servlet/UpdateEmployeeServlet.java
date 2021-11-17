package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Employee;
import com.employee.EmployeeDao;
import com.employee.EmployeeDaoFactory;

@SuppressWarnings("serial")
public class UpdateEmployeeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		out.println("<br>");
		request.getRequestDispatcher("update.html").include(request, response);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		out.println("<br>");
		out.print("<div class=\"container\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-lg-3\"></div>");
		out.print("<div class=\"col-lg-6\">");
		Employee e = new Employee();
		e.setName(request.getParameter("name"));
		e.setEmail(request.getParameter("email"));
		e.setGender(request.getParameter("gender"));
		e.setCountry(request.getParameter("country"));
		try {
			dao.updateEmployee(e);
			out.print("<p>Employee updated successfully</p>");
		} catch (SQLException e1) {
			e1.printStackTrace();
			out.print("<p>There was an error updating employee</p>");
		} catch (IndexOutOfBoundsException e2) {
			e2.printStackTrace();
			out.print("<p>There was an error updating employee</p>");
			out.print("<p>There is no employee named: " + e.getName() + "</p>");
		} catch (Exception e3) {
			e3.printStackTrace();
			out.print("<p>There was an error updating employee</p>");
		}
		out.print("</div>");
		out.print("<div class=\"col-lg-3\"></div>");
		out.print("</div>");
		out.print("</div>");
		out.close();
	}

}
