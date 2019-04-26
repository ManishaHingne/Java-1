package org.sunbeam.dac.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sunbeam.dac.pojo.Book;

public class Program
{
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/DacDB?useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "manager";
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			//Step 1
			Class.forName(DRIVER);
			
			//Step 2
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//Setp 3
			statement = connection.createStatement();
			
			//Step 4:
			String sql = "select * from BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				/*while( rs.next())
				{
					Book book = new Book();
	
					book.setBookId( rs.getInt("book_id") );
					
					book.setSubjectName( rs.getString("subject_name"));
					
					book.setBookName( rs.getString("book_name") );
					
					book.setAuthorName( rs.getString("author_name") );
					
					book.setPrice( rs.getFloat("price") );
					
					System.out.println(book.toString());
				}*/
				
				while( rs.next())
				{
					Book book = new Book( rs.getInt("book_id"), rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price") );
						
					System.out.println(book.toString());
				}
				
			}
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			//Step 5
			try 
			{
				statement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
