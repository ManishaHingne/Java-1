package org.sunbeam.dac.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sunbeam.dac.pojo.Book;
import org.sunbeam.dac.utils.DBUtils;

public class BookDao implements Closeable
{
	private Connection connection;
	private Statement statement;
	public BookDao() throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.statement = this.connection.createStatement();
	}
	//insert
	public int insert( Book book ) throws Exception
	{
		String sql = "insert into BookTable values("+book.getBookId()+",'"+book.getSubjectName()+"','"+book.getBookName()+"','"+book.getAuthorName()+"',"+book.getPrice()+")";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	//update
	public int update( int bookId, float price )throws Exception
	{
		String sql = "update BookTable set price="+price+" where book_id="+bookId+"";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	//delete
	public int delete( int bookId )throws Exception
	{
		String sql = "delete from BookTable where book_id="+bookId+"";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	//select
	public List<Book> getBooks( )throws Exception
	{
		List<Book> bookList = new ArrayList<>();
		String sql = "select * from BookTable";
		try( ResultSet rs =  this.statement.executeQuery(sql);)
		{
			while( rs.next())
			{
				Book book = new Book( rs.getInt("book_id"), rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price") );
				bookList.add(book);
			}
		}
		return bookList;
	}
	@Override
	public void close() throws IOException 
	{
		try
		{
			if( this.statement != null )
				this.statement.close();
			if( this.connection != null )
				this.connection.close();
		} 
		catch (SQLException cause)
		{
			throw new IOException(cause);
		}
	}
}
