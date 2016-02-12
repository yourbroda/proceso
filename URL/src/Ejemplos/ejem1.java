package Ejemplos;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ejem1 {

	public static void main(String args[]){
		
		Scanner teclado=new Scanner(System.in);
		
		try
		{
			System.out.println("URL: ");
			String url=teclado.nextLine();
			URL u= new URL(url);
			System.out.println("ptrocolo = "+u.getProtocol());
			System.out.println("ordenador = "+ u.getHost());
			System.out.println("fichero = "+u.getFile());
			System.out.println("puerto = "+u.getPort());
			System.out.println("ref = "+u.getRef());
		}catch(MalformedURLException e){
			System.out.println("URL erronea: "+args [0]);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
}
