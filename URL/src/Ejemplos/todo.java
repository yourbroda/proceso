package Ejemplos;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.*;

public class todo {
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		String url="";
		while(true){
			System.out.println("URL:");
			url=teclado.nextLine();
			if(url.equals("salir")){
				break;
			}
			if(url.endsWith("gif") || url.endsWith("jpg")){
				imagen(url);
			}else{
				System.out.println("palabra a buscar");
				String palabra=teclado.nextLine();
				buscar(url,palabra);
				
				
		}
			
		
			
	}

	}
	public static void buscar(String url, String palabra){
		try{
			
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
					
					if(array[i].equals(palabra)){
						cont=cont+1;
					}
				}
			}
			System.out.println("Concurrencias"+cont);
				
			in.close();
				
			
			
		}catch(MalformedURLException e){
			System.out.println("URL erronea: ");
		}catch(Exception ei){
			System.out.println("Error: "+ei.getMessage());
		}
		
	}
	public static void imagen(String url){
		
		try{
			
			
			URL u = new URL (url);
			URLConnection uc=u.openConnection();
			String ct = uc.getContentType();
			int cl= uc.getContentLength();
			if(url.endsWith("jpg")){
				System.out.println(cl/(1024*1024)+" MB");
			}else{
				
			
			if (ct.startsWith("text/") || cl==-1){
				System.out.println("ERROR: Esta URL "+"es de tipo texto");
				return;
			}else{
				System.out.println("Funciono");
			}
			InputStream is= uc.getInputStream();
			BufferedInputStream in = new BufferedInputStream (is);
			String fich = u.getFile();
			fich= fich.substring(fich.lastIndexOf('/')+1);
			FileOutputStream fout = new FileOutputStream("imagen.gif");
			BufferedOutputStream out= new BufferedOutputStream(fout);
			int i;
			while((i = in.read()) !=-1)
				out.write(i);
			
			out.flush();
			in.close();
			out.close();
			}
		}catch(MalformedURLException e){
			System.out.println("URL erronea: "+ url);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}

	
}
	
	

}

