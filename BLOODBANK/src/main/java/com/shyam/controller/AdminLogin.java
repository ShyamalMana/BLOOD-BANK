package com.shyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("uname");
		String password=req.getParameter("pass");
		
		PrintWriter p=resp.getWriter();
		if(name.equals("Admin") && password.equals("Admin"))
		{
			p.print("<h1 style='color:Green'><center>Login Succsessfull</center><h1>");
			req.getRequestDispatcher("Dashbord.jsp").include(req, resp);
		}
		else {
			p.print("<h1 style='color:red'><center>Plz Enter Valid Details</center><h1>");
			 req.getRequestDispatcher("Admin.jsp").include(req, resp);
		}
	
	}

}
