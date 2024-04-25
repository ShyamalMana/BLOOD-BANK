package com.shyam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shyam.dao.Donerdao;
import com.shyam.dto.Doner;


@WebServlet("/DonerSignup")
public class DonerSignup extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		long phone = Long.parseLong(req.getParameter("phone"));
//		String bgroup=req.getParameter("bgroup");
		int age = Integer.parseInt(req.getParameter("age"));
//		int quantity=Integer.parseInt(req.getParameter("qntity"));
//		double amount=Double.parseDouble(req.getParameter("amount"));
		String status = "Inactive";

		if (age > 18) {
			Doner d = new Doner();
			d.setName(name);
			d.setEmail(email);
			d.setPassword(pass);
			d.setPhone(phone);
//		d.setBlood_group(bgroup);
			d.setAge(age);
//		d.setQuantity(quantity);
//		d.setAmount(amount);
			d.setStatus(status);

			Donerdao doner = new Donerdao();
			doner.Save(d);
			resp.getWriter().print("<h1>SgnUp Successful</h1>");
			req.getRequestDispatcher("DonerLogin.jsp").include(req, resp);
		} else {
			resp.getWriter().print("<h1>Age Should Be More than 18</h1>");
			req.getRequestDispatcher("DonerSignup.jsp").include(req, resp);
		}
	}

}
