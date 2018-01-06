package com.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigContex extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		ServletConfig config=getServletConfig();
		ServletContext context=getServletContext();
		String s1=config.getInitParameter("hello");
		System.out.println(s1);
		Enumeration<String> ar=config.getInitParameterNames();
		while(ar.hasMoreElements())
		{
			String s2=ar.nextElement();
			System.out.println(config.getInitParameter(s2));
		}
		PrintWriter out=response.getWriter();
		out.println("Servlet name  ="+config.getServletName());
		
		//System.out.println(s3);
		context.setAttribute("p1","changed p1");
		String s4=(String) context.getAttribute("p1");
		System.out.println("p1 ="+s4);
		context.removeAttribute("p2");
	}
}
