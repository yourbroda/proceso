package rmi;

import java.rmi.*;

public interface  InterfaceServidor extends Remote {

	String saludo(String nombre)throws RemoteException;
	int suma(int num1, int num2)throws RemoteException;
	int resta(int num1, int num2)throws RemoteException;
	int multiplicar(int num1, int num2)throws RemoteException;
	double dividir(int num1, int num2)throws RemoteException;
}
