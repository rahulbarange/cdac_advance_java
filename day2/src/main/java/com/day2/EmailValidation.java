package com.day2;
import java.util.Base64;  
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register.cdac")
public class EmailValidation extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//password encoder
		Base64.Encoder encoder = Base64.getEncoder();  
		String str = encoder.encodeToString(password.getBytes());  
	    System.out.println("Encoded string: "+str);  
	    String data = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "cdac");
                Statement st = con.createStatement();
                
                
                ResultSet rs = st.executeQuery("select * from register where email='" + email + "'");
                int count = 0;
                while (rs.next()) {
 
                    count++;
                }
 
                if (count > 0) {
                    data = "Email-ID already exists!";
                } else {
                    data = "You can register now!!!!";
                    try {
            			Class.forName("com.mysql.cj.jdbc.Driver");
            			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "cdac");
            			
            			
            			
            			PreparedStatement stt = conn.prepareStatement("insert into register  values(?, ?, ?, ?, ?)");
            			stt.setString(1, name); //substituting ? with actual value
            			stt.setString(2, email);
            			stt.setInt(3, mobileNo);
            			stt.setString(4, username);
            			stt.setString(5, str);
            			stt.executeUpdate();
            			PrintWriter out = response.getWriter();
            			out.write("<html><body>");
            			out.write("<h1>Registration successful!</h1>");
            			out.write("</body></html>");
            			conn.close();
            		}catch(SQLIntegrityConstraintViolationException e) {
//            			e.printStackTrace();
            			PrintWriter out = response.getWriter();
            			out.write("<h1>Registration failed!</h1>");
            		}
            		catch(Exception e) {
            			e.printStackTrace();
            		}
            		
                }
                PrintWriter out = response.getWriter();
                out.println(data);
                System.out.println(data);
            } catch (Exception e) {
                System.out.println(e);
            }
		
	}

}
