package socketsSeguros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class Cliente {

	public static void main(String []args){
		
		String host="Localhost";
		int port=6000;
		
		System.out.println("Programa cliente iniciado...");
		SSLSocketFactory sfact=(SSLSocketFactory)SSLSocketFactory.getDefault();
		
		try{
			SSLSocket Cliente=(SSLSocket)sfact.createSocket(host, port);
			//Creo flujo de salida al servidor
			DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
			
			//Envio un Saludo al servidor
			flujoSalida.writeUTF("Saludos al servidor desde el cliente");
			//Creo flujo de entrada al servidor
			DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
			//El servidor me envia un mensaje
			System.out.println("Recibiendo del servidor: \n\t"+flujoEntrada.readUTF());
			//Cerrar streams y sockets
			
			flujoSalida.close();
			flujoEntrada.close();
			Cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
