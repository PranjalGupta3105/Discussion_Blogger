package com.discussblog.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String repassword=request.getParameter("repass");
		String mobileno=request.getParameter("mobno");
		String seqques=request.getParameter("seqques");
		String answer=request.getParameter("answer");
		       
		PrintWriter out=response.getWriter(); 
		if(username.equals(email))
				{
			out.println(username);
			out.println(email);
			out.println("You are at success");
				}
			 
		try       {
			Class.forName("com.mysql.jdbc.Driver");              
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","pgmysql" );              
		Statement stmt=con.createStatement();
		int i= stmt.executeUpdate("insert into Signup values('"+username+"', '"+email+"', '"+password+"', '"+repassword
				+"', '"+mobileno+"', '"+seqques+"', '"+	answer+"');");              
		if(i>0)                
		out.println("Inserted Successfully");              
		else                
		out.println("Insert Unsuccessful");        
		}        
		catch(Exception e)  
		{         
			
			out.println(e);               
		 }
		
	
	}

}
