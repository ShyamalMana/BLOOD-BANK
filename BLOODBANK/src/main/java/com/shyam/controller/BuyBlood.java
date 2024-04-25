package com.shyam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Blood_Groupdao;
import com.shyam.dao.Buyerdao;
import com.shyam.dao.Donerdao;
import com.shyam.dto.Blood_Group;
import com.shyam.dto.Buyer;
import com.shyam.dto.Doner;


@WebServlet("/Byu")
public class BuyBlood extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		  
		 
		Blood_Groupdao bg=new Blood_Groupdao();
		List<Blood_Group> blood=bg.findbyid(id);
		
		Buyer buyer=new Buyer();
		buyer.setListofblood_group(blood);
		
		Buyerdao b=new Buyerdao();
		b.update(buyer);
		
		
		
		Donerdao dd=new Donerdao();
		Doner x=dd.findbyBloodid(id);
		
		x.setStatus("Inactive");
		dd.update(x);
		
		
		
		resp.getWriter().print("<h1><center>Buy Successfull....</center></h1>"); 
		req.getRequestDispatcher("Mainpage.html").include(req, resp);
		
	}

}
