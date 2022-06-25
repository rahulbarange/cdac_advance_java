package com.day1;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/third.day1")
public class A02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("t1"));
		String s1=request.getParameter("t1");
		Date d1=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(d1);  
	    System.out.println(strDate);
	    
	    String s2[]=s1.split("-");
	    
	    System.out.println(Arrays.toString(s2));
	    String s3[]=strDate.split("/");
	    
	    int year=Integer.parseInt(s2[0])-Integer.parseInt(s3[2]);
	    int month=Integer.parseInt(s2[1])-Integer.parseInt(s3[1]);
	    int days=Integer.parseInt(s2[2])-Integer.parseInt(s3[0]);
	    response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.write("<html><body>");
		out.write("<h1>Your age is  "+ year+ "  year"+month+"  month"+days+"  days"+" <h1/>");
		out.write("</body></html>");
	    
	    
		
		//System.out.println(d1);
		
		
	}

	

}
