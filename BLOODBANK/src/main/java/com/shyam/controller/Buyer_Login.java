package com.shyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Buyerdao;
import com.shyam.dto.Buyer;



@WebServlet("/BuyerLogin")
public class Buyer_Login extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		Buyerdao buyerdao=new Buyerdao();
		Buyer b=buyerdao.findbyemail(email);
		
		PrintWriter p=resp.getWriter();
		
		if(b==null) {
			p.print("<h1 style='color:red'><center>Plz Enter Valid Email Id</center><h1>");
			 req.getRequestDispatcher("BuyerLogin.jsp").include(req, resp);
	}else
	{
		if(pass.equals(b.getPassword())) {
			p.print("<h1 style='color:Green'><center>Login Succsessfull</center><h1>");
			req.getSession().setAttribute("buyer", b);
			req.getRequestDispatcher("BloodDetails.jsp").include(req, resp);
		}
			else {
				p.print("<h1 style='color:red'><center>Plz Enter Valid password</center><h1>");
				 req.getRequestDispatcher("BuyerLogin.jsp").include(req, resp);
			}
	}
		
	}

}
