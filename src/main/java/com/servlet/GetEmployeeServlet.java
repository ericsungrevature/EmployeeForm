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
public class GetEmployeeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		out.println("<br>");
		request.getRequestDispatcher("get.html").include(request, response);
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		out.println("<br>");
		out.print("<div class=\"container\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-lg-3\"></div>");
		out.print("<div class=\"col-lg-6\">");
		out.print("<div class=\"wrapper\">");
		out.print("<table class=\"table table-bordered\">");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>Name</th>");
		out.print("<th>Email</th>");
		out.print("<th>Gender</th>");
		out.print("<th>Country</th>");
		out.print("</tr>");
		out.print("</thead>");
		try {
			Employee e = dao.getEmployee(request.getParameter("name"));
			out.print("<tbody>");
			out.print("<tr>");
			out.print("<th>" + e.getId() + "</th>");
			out.print("<th>" + e.getName() + "</th>");
			out.print("<th>" + e.getEmail() + "</th>");
			out.print("<th>" + e.getGender() + "</th>");
			out.print("<th>" + e.getCountry() + "</th>");
			out.print("</tr>");
			out.print("</tbody>");
			out.print("</table>");
			out.print("</div>");
		} catch (SQLException e1) {
			e1.printStackTrace();
			out.print("<p>There was an error retrieving employee</p>");
		} catch (IndexOutOfBoundsException e2) {
			e2.printStackTrace();
			out.print("<p>There was an error retrieving employee</p>");
			out.print("<p>There is no employee named: " + request.getParameter("name") + "</p>");
		} catch (Exception e3) {
			e3.printStackTrace();
			out.print("<p>There was an error retrieving employee</p>");
		}
		out.print("</div>");
		out.print("<div class=\"col-lg-3\"></div>");
		out.print("</div>");
		out.print("</div>");
		out.close();
	}

}
