package com.skillnext1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")   // ⭐ THIS WAS MISSING
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Employee Servlet is WORKING</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setSalary(salary);

        EmployeeDAO.save(emp);

        res.sendRedirect("success.jsp");
    }
}
