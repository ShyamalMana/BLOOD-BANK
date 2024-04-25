package com.shyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Donerdao;
import com.shyam.dto.Doner;


@WebServlet("/DonerLogin")
public class DonerLogin extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Donerdao doner=new Donerdao();
		Doner dd=doner.findbyemail(email);
		PrintWriter p=resp.getWriter();
		
		if(dd==null) {
			p.print("<h1 style='color:red'><center>Plz Enter Valid Email Id</center><h1>");
			 req.getRequestDispatcher("DonerLogin.jsp").include(req, resp);
	}else
	{
		if(pass.equals(dd.getPassword())) {
			p.print("<h1 style='color:Green'><center>Login Succsessfull</center><h1>");
			req.getSession().setAttribute("Doner", dd);
			req.getRequestDispatcher("DonateBlood.jsp").include(req, resp);
		}
			else {
				p.print("<h1 style='color:red'><center>Plz Enter Valid password</center><h1>");
				 req.getRequestDispatcher("DonerLogin.jsp").include(req, resp);
			}
	}
		
	}

}
