package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Program
{
	public static final int PORT = 5214; 
	public static void main(String[] args) 
	{
		Socket socket = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			socket = new Socket("localhost", PORT);
			inputStream = new DataInputStream( new BufferedInputStream( socket.getInputStream( )));
			outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			String text;
			do
			{
				text = inputStream.readUTF();
				System.out.println("C:Server	:	"+text);
				
				System.out.print("C:Client	:	");
				text = sc.nextLine();
				outputStream.writeUTF(text);
				outputStream.flush();
			}while( !text.equalsIgnoreCase("end"));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			try
			{
				inputStream.close();
				outputStream.close();
				socket.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
