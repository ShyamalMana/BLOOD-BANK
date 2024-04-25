package com.shyam.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Buyerdao;
import com.shyam.dto.Buyer;



@WebServlet("/Buyersignup")
public class Buyer_Signup extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		long mob=Long.parseLong(req.getParameter("mobile"));
		String gender=req.getParameter("gender");
		int age=Integer.parseInt(req.getParameter("age"));
		Date date=Date.valueOf(req.getParameter("date"));
		String bgroup=req.getParameter("bgroup");
		
		Buyer b=new Buyer();
		b.setName(name);
		b.setEmail(email);
		b.setPassword(password);
		b.setMobile(mob);
		b.setGender(gender);
		b.setAge(age);
		b.setDate(date);
		b.setBlood_group(bgroup);
		b.getListofblood_group();
		
		Buyerdao Buyer=new Buyerdao();
		Buyer.Save(b);
		
		resp.getWriter().print("<h1><center> Buyer data Saved</center></h1>");
		req.getRequestDispatcher("BuyerLogin.jsp").include(req, resp);
	
	}

}
