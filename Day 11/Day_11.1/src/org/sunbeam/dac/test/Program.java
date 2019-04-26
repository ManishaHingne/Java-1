package org.sunbeam.dac.test;
class TickTock
{
	public void tick( boolean running ) throws InterruptedException
	{
		synchronized( this )
		{
			if( !running )
			{
				this.notify();
				return;
			}
			System.out.print("Tick	");
			this.notify();
			this.wait();
		}
	}
	public void tock( boolean running ) throws InterruptedException
	{
		synchronized( this )
		{
			if( !running )
			{
				this.notify();
				return;
			}
			System.out.println("	Tock");
			this.notify();
			this.wait();
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
				for( int count = 1; count <= 5; ++ count )
				{
					tt.tick( true );
					Thread.sleep(250);
				}
				tt.tick( false );
			}
			else
			{
				for( int count = 1; count <= 5; ++ count )
				{
					tt.tock( true );
					Thread.sleep(250);
				}
				tt.tock( false );
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
			CThread tockThread = new CThread("TockThread");
			CThread tickThread = new CThread("TickThread");
			
			/*while( true )
			{
				System.out.println("tickThread	:	"+tickThread.thread.getState().name());
				System.out.println("tockThread	:	"+tockThread.thread.getState().name());
				Thread.sleep(100);
			}*/
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
