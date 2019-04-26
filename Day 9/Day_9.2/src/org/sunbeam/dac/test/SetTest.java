package org.sunbeam.dac.test;

import java.util.Set;

public class SetTest
{
	private Set<Book> bookList;
	public void setBookList(Set<Book> bookList) 
	{
		this.bookList = bookList;
	}
	public void add(Book book) 
	{
		if( this.bookList != null && book != null )
			this.bookList.add(book);
	}
	public Book find(int bookId)
	{
		if( this.bookList != null )
		{
			for( Book book : this.bookList )
			{
				if( book.getId() == bookId )
					return book;
			}
		}
		return null;
	}
	public boolean remove(int bookId ) 
	{
		if( this.bookList != null )
		{
			Book key = new Book();
			key.setId(bookId);
			if( this.bookList.contains(key))
			{
				this.bookList.remove(key);
				return true;
			}
		}
		return false;
	}
	public void print()
	{
		if( this.bookList != null )
			this.bookList.forEach(System.out::println);
	}
}
