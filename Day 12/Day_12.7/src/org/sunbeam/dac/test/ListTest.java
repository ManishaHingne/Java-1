package org.sunbeam.dac.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;

public class ListTest 
{
	private List<Employee> empList;
	public void setEmpList(List<Employee> empList) 
	{
		this.empList = empList;
	}
	public void addRecord(Employee[] employees) 
	{
		if( this.empList != null && employees != null )
		{
			for (Employee employee : employees) 
				this.empList.add(employee);
		}
	}
	/*public Employee findRecord(int empid) 
	{
		if( this.empList != null )
		{
			for( Employee emp : this.empList )
			{
				if( emp.getEmpid() == empid )
					return emp;
			}
		}
		return null;
	}*/
	public Employee findRecord(int empid) 
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				int index = this.empList.indexOf(key);
				return this.empList.get(index);
			}
		}
		return null;
	}
	/*public boolean removeRecord(int empid )
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				int index = this.empList.indexOf(key);
				this.empList.remove(index);
				return true;
			}
		}
		return false;
	}*/
	public boolean removeRecord(int empid )
	{
		if( this.empList != null )
		{
			Employee key = new Employee();
			key.setEmpid(empid);
			if( this.empList.contains(key))
			{
				this.empList.remove(key);
				return true;
			}
		}
		return false;
	}
	public void print(Comparator<Employee> comparator) 
	{
		if( this.empList != null )
		{
			this.empList.sort(comparator);
			this.empList.forEach(System.out::println);
		}
	}
	public void writeRecord( String pathname )throws Exception
	{
		try( ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(pathname)))))
		{
			outputStream.writeObject(this.empList);
		}
	}
	public void readRecord( String pathname )throws Exception
	{
		try( ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(pathname)))))
		{
			this.empList = (List<Employee>) inputStream.readObject();
		}
	}
}
