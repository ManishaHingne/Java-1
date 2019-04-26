package org.sunbeam.dac.test;
class TickTock
{
	public void tick(  ) throws InterruptedException
	{
		synchronized( this )
		{
			System.out.print("Tick	");
			this.notify();
			this.wait( 500 );
		}
	}
	public void tock( ) throws InterruptedException
	{
		synchronized( this )
		{
			System.out.println("	Tock");
			this.notify();
			this.wait( 500 );
		}
	}
}
class CThread implements Runnable
{
	Thread thread;
	public CThread( String name )
	{
		this.thread = new Thread(this);
		this.thread.setName(name);
		this.thread.start();
	}
	static TickTock tt = new TickTock();
	@Override
	public void run() 
	{
		try
		{
			if( Thread.currentThread().getName().equalsIgnoreCase("TickThread"))
			{
				for( int count = 1; count <= 10; ++ count )
				{
					tt.tick(  );
					Thread.sleep(250);
				}
			}
			else
			{
				for( int count = 1; count <= 10; ++ count )
				{
					tt.tock(  );
					Thread.sleep(250);
				}
			}
		}
		catch (InterruptedException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		try
		{
			CThread tickThread = new CThread("TickThread");
			CThread tockThread = new CThread("TockThread");
			while( true )
			{
				System.out.println("tickThread	:	"+tickThread.thread.getState().name());
				System.out.println("tockThread	:	"+tockThread.thread.getState().name());
				Thread.sleep(100);
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
