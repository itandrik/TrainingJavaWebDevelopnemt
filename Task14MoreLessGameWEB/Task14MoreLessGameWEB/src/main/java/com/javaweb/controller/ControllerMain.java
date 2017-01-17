package com.javaweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.controller.config.Initialization;
import com.javaweb.controller.config.Pages;

/**
 * Servlet implementation class ControllerMain
 */
public class ControllerMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(Initialization.LOW_BOUND_SETUP);
		System.out.println(request.getParameter(Initialization.LOW_BOUND_SETUP));
		System.out.println(request.getParameter(Initialization.HIGH_BOUND_SETUP));
		//response.sendRedirect(Pages.GAME_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
