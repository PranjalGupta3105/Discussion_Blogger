package com.discussblog.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forum
 */
public class Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eml=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		int passwrd=Integer.valueOf(pass);
		
		PrintWriter out=response.getWriter();

		Connection con=null;        
		Statement stmt=null;  
		
		//PrintWriter out=res.getWriter();        
		try       
		{              
		Class.forName("com.mysql.jdbc.Driver");              
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","pgmysql" );              
		//stmt=con.createStatement();
		PreparedStatement ps=con.prepareStatement("select Username from Signup where E_mail=? && Password=?");
		ps.setString(1,eml);
		ps.setInt(2,passwrd);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		{
			
			//out.println("Yeah!!");
			response.sendRedirect("views/Main.html");
		}
		/*rs.beforeFirst();  
		ResultSetMetaData rsmd=rs.getMetaData();
		  out.println(rsmd.getColumnName(1)+rs.getInt(3));*/
		/*  if(rs.getString(2)==null)
		  {
		System.out.println("I am Logged In");	  
			  
		  }*/
		  
		  //.....................................zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz...............
		//out.println(rsmd.getColumnName(1));
			
		//ResultSet i=stmt.executeQuery("select E_mail,Password from Signup where E_mail="+eml+";");//"and Password="+pass+";");
		//String nam=i.getString("E_mail");
		//String p=i.getString("Password");
		//int rs=stmt.executeUpdate("insert into login values('"+eml+"', '"+pass+"');");
		
/*		ResultSet i=stmt.executeQuery("select E_mail,Password from Signup where E_mail="+eml+";");//"and Password="+pass+";");
		String nam=i.getString("E_mail");
		String p=i.getString("Password");
		System.out.println(nam+p);
		//int i = stmt.executeUpdate("insert into entry values('"+eml+"', '"+pass+"')");              
		if(i==null)                
		out.println("Login successful"+i);              
		else                
		out.println("login Unsuccessful");        
		*/
		}        
		catch(Exception e)        
		{          out.println(e);               
		 }
		
		/*
		 * Connection con=null;        
Statement stmt=null;        
PrintWriter out=res.getWriter();        
try       
{              
Class.forName("com.mysql.jdbc.Driver");              
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","pgmysql" );              
stmt=con.createStatement();              
int i = stmt.executeUpdate("insert into entry values('"+eml+"', '"+pass+"')");              
if(i>0)                
out.println("Inserted Successfully");              
else                
out.println("Insert Unsuccessful");        
}        
catch(Exception e)        
{          out.println(e);               
 }
		
		 *
		 *	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","pgmysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
		{
		Statement stmt = null;
		try {
			stmt = (Statement) ((java.sql.Connection) con).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs=stmt.executeQuery("insert into entry values('"+eml+"', '"+pass+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 */
	}

}
