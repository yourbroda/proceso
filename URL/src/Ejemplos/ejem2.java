package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ejem2 {
	
	public static void main(String[]args){
		Scanner teclado=new Scanner(System.in);
		try{
			System.out.println("URL: ");
			String url=teclado.nextLine();
			String [] array;
			int cont=0;
			URL u= new URL(url);
			BufferedReader in=new BufferedReader(new InputStreamReader(u.openStream()));
			String linea;
			while((linea=in.readLine())!=null){
				//System.out.println(linea);
				linea.toLowerCase();
				array=linea.split(" ");
				for(int i=1; i<array.length;i++){
					System.out.println(array[i]);
					if(array[i].equals("olfato")){
						cont=cont+1;
					}
				}
			}
			System.out.println(cont);
				
			in.close();
				
			
			
		}catch(MalformedURLException e){
			System.out.println("URL erronea: "+args [0]);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		
	}

}
