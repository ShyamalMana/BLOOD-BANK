package com.shyam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Donerdao;
import com.shyam.dto.Blood_Group;
import com.shyam.dto.Doner;


@WebServlet("/donate")
public class Donate extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String bgroup=req.getParameter("Blood_group");
		int quantity=Integer.parseInt(req.getParameter("Quantity"));
		double Amount=quantity*10;
		
		Blood_Group b= new Blood_Group();
		b.setBloog_group(bgroup);
		
		
		Donerdao dao= new Donerdao();
		Doner d=(Doner) req.getSession().getAttribute("Doner");
		d.setBlood_group(bgroup);
		d.setQuantity(quantity);
		d.setAmount(Amount);
		d.setBloodgroup(b);
		
		
		Donerdao doner=new Donerdao();
		doner.update(d);
		doner.SAve(b);
		
		
		resp.getWriter().print("<h1>Donated Successful</h1>");
		req.getRequestDispatcher("Mainpage.html").include(req, resp);
		
		
	}

}
