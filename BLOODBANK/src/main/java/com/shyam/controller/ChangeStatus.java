package com.shyam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Donerdao;
import com.shyam.dto.Doner;



@WebServlet("/Status")
public class ChangeStatus extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
//		String status=req.getParameter("Status");
		
		Donerdao d=new Donerdao();
		Doner doner=d.findbyid(id);
//		if(status.equals("Active")) {
//		doner.setStatus("Inactive");}
//		else {
			doner.setStatus("Active");
//		}
		d.update(doner);
		resp.getWriter().print("<h1><center>Blood Status Updated</center> </h1>");
		req.getRequestDispatcher("Mainpage.html").include(req, resp);
		
		
	}

}
