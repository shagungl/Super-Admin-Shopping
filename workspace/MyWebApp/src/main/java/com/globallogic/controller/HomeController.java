package com.globallogic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author ravin
 *
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		System.out.println("I am get request");

		RequestDispatcher rs = request.getRequestDispatcher("/home.html");
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I am POST request");
	}

}
