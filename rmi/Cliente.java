package rmi;

import java.rmi.*;
import java.io.*;
import java.util.Scanner;
public class Cliente {

	public static void main(String[] args) throws IOException, NotBoundException {
		
	try{
		Scanner teclado=new Scanner(System.in);
		BufferedReader entrada=new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Introduce nombre: ");
		String nombre=entrada.readLine();
		
		InterfaceServidor obj=(InterfaceServidor) Naming.lookup("//127.0.0.1/ObjetoHola");
		String mensaje=obj.saludo(nombre);
		System.out.println(mensaje);
		
		System.out.println("Introduce un numero");
		int num1=teclado.nextInt();
		System.out.println("Introduce otro numero");
		int num2=teclado.nextInt();
		System.out.println("Que quieres hacer?");
		System.out.println("1 Sumar");
		System.out.println("2 Restar");
		System.out.println("3 Multiplicar");
		System.out.println("4 Dividir");
		System.out.print("Eleccion: ");
		int opc=teclado.nextInt();
		
		
		switch(opc){
		
		case 1:
			System.out.println(num1+"+"+num2+"="+obj.suma(num1, num2));
			break;
		case 2:
			System.out.println(num1+"-"+num2+"="+obj.resta(num1, num2));
			break;
		case 3:
			System.out.println(num1+"*"+num2+"="+obj.multiplicar(num1, num2));
			break;
		case 4:
			System.out.println(num1+"/"+num2+"="+obj.dividir(num1, num2));
			break;
		}
		
	}catch(Exception e){
		System.out.println("Exeption: "+e.getMessage());
		e.printStackTrace();
	}
	}

}
