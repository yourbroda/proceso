package rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class Servidor extends UnicastRemoteObject implements InterfaceServidor {

	public Servidor()throws RemoteException{
		super();
		
	}
	public String saludo(String nombre) throws RemoteException {
		return "Hola "+nombre;
	}
	public static void main(String[] args) {
		
		try{
			Servidor obj=new Servidor();
			Naming.rebind("rmi://127.0.0.1/ObjetoHola", obj);
			System.out.println("Objeto Hola registrado");
			
		}catch(RemoteException re){
			System.out.println("Error en el Servidor: "+re.getMessage() );
			
			re.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException Servidor: "+e.getMessage() );
			e.printStackTrace();
		}

	}
	@Override
	public int suma(int num1, int num2) throws RemoteException {
		
		return num1+num2;
	}
	@Override
	public int resta(int num1, int num2) throws RemoteException {
		// TODO Auto-generated method stub
		return num1-num2;
	}
	@Override
	public int multiplicar(int num1, int num2) throws RemoteException {
		// TODO Auto-generated method stub
		return num1*num2;
	}
	@Override
	public double dividir(int num1, int num2) throws RemoteException {
		// TODO Auto-generated method stub
		return num1/num2;
	}

	

}
