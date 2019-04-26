package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Program
{
	public static final int PORT = 5214; 
	public static void main(String[] args) 
	{
		ServerSocket serverSocket = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server is running...");
			Socket socket = serverSocket.accept();
			
			inputStream = new DataInputStream( new BufferedInputStream( socket.getInputStream( )));
			outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			String text;
			do
			{
				System.out.print("S:Server	:	");
				text = sc.nextLine();
				outputStream.writeUTF(text);
				outputStream.flush();
				
				text = inputStream.readUTF();
				System.out.println("S:Client	:	"+text);
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
				serverSocket.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
