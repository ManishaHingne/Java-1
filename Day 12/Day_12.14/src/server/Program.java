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
		try( ServerSocket serverSocket = new ServerSocket(PORT);)
		{
			
			System.out.println("Server is running...");
			while( true )
			{
				Socket socket = serverSocket.accept();
				new CommunicationHandler(socket);
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
