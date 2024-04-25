package com.shyam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Donerdao;
import com.shyam.dto.Doner;



@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 int id=Integer.parseInt(req.getParameter("id"));
			
			Donerdao e= new Donerdao();
			
			Doner ee=e.findbyid(id);
			e.Delete(ee);
		
			
			resp.getWriter().print("<h1 style=\"color:red\"><center>Blood Removed....</center></h1>");
		RequestDispatcher r=req.getRequestDispatcher("Dashbord.jsp");
		r.include(req, resp);
		
	}
}
