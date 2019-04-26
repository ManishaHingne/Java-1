package org.sunbeam.dac.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils
{
	private static Connection connection;
	public static Connection getConnection( )throws Exception
	{
		InputStream inputStream = new FileInputStream("Config.properties");
		Properties p = new Properties();
		p.load(inputStream);
		
		Class.forName(p.getProperty("DRIVER"));
		connection = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
		return connection;
	}
	public static void closeConnection( )throws Exception
	{
		if( connection != null )
			connection.close();
	}
}
