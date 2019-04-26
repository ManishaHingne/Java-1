package org.sunbeam.dac.test;

//public class Book implements Comparable<Book>
public class Book 
{
	private int id;
	private String name;
	private String author;
	private float price;
	public Book() //def ctor 
	{	}
	public Book(int id, String name, String author, float price) 
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	/*@Override
	public int compareTo(Book other ) 
	{
		return this.id - other.id;
	}*/
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() 
	{
		return String.format("%-5d%-30s%-30s%-10.2f", this.id, this.name, this.author, this.price);
	}
}
