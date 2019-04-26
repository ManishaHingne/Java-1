package org.sunbeam.dac.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.sunbeam.dac.pojo.Book;

public class Program
{	
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			InputStream inputStream = new FileInputStream("Config.properties");
			Properties p = new Properties();
			p.load(inputStream);
			
			Class.forName(p.getProperty("DRIVER"));
			connection = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
			statement = connection.createStatement();
			//String sql = "insert into BookTable values(1025,'OS','Operating System Concept','Galvin',550)";
			//String sql = "update BookTable set price=575 where book_id=1025";
			String sql = "delete from BookTable where book_id=1025";
			int updateCount = statement.executeUpdate(sql);
			System.out.println(updateCount+" row(s) affected");
			
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
