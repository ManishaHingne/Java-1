package org.sunbeam.dac.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program
{
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
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
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
					int bookId = rs.getInt(1);
					String subjectName = rs.getString(2);
					String bookName = rs.getString(3);
					String authorName = rs.getString(4);
					float price = rs.getFloat(5);
					System.out.printf("%-5d%-10s%-30s%-30s%-10.2f\n", bookId, subjectName, bookName, authorName, price);
				}*/
				while( rs.next())
				{
					int bookId = rs.getInt("book_id");
					String subjectName = rs.getString("subject_name");
					String bookName = rs.getString("book_name");
					String authorName = rs.getString("author_name");
					float price = rs.getFloat("price");
					System.out.printf("%-5d%-10s%-30s%-30s%-10.2f\n", bookId, subjectName, bookName, authorName, price);
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
