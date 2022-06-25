package com.day1;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Second.day1")
public class A01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a1=Integer.parseInt(request.getParameter("t1"));
		int a2=Integer.parseInt(request.getParameter("t2"));
		int ans=0;
		//System.out.println(request.getParameter("b1"));
		if(request.getParameter("b1")==null) {
			 ans=a1-a2;
			
		}
		else {
			 ans=a1+a2;
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.write("<html><body>");
		out.write("<h1>Answer is "+ans+"<h1/>");
		out.write("</body></html>");
	}

	

}
