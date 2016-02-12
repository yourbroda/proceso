package Ejemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

public class hilo extends Thread{
	
	String enlace;
	
	public hilo(String enlace) {
		super();
		this.enlace = enlace;
	}
	public void run(String enlace){
		try {
			wait();
			if(capturarImg(enlace)){
				System.out.println("Imagen");
			}else{
				System.out.println();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static boolean capturarImg(String enlace){
		
		try {
			URL u = new URL (enlace);
			URLConnection uc=u.openConnection();
			String ct = uc.getContentType();
			int cl= uc.getContentLength();
			if (ct.startsWith("text/") || cl==-1){
				System.out.println("ERROR: Esta URL "+"es de tipo texto");
				return false;
			}else{
				System.out.println("Funciono");
			}
			InputStream is= uc.getInputStream();
			BufferedInputStream in = new BufferedInputStream (is);
			String fich = u.getFile();
			fich= fich.substring(fich.lastIndexOf('/')+1);
			FileOutputStream fout = new FileOutputStream(fich);
			BufferedOutputStream out= new BufferedOutputStream(fout);
			int i;
			while((i = in.read()) !=-1)
				out.write(i);
			out.flush();
			in.close();
			out.close();
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static String texto(String palabra){
		
		String linea="";
		try{
			
			String url=palabra;
			
			URL u= new URL(url);
			BufferedReader in=new BufferedReader(new InputStreamReader(u.openStream()));
			
			while((linea=linea+in.readLine())!=null){
				
			}
				
			in.close();
				
			return linea;
			
		}catch(MalformedURLException e){
			System.out.println("URL erronea: ");
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		return linea;
	}
	public static String contar(String cadena, String palabra){
		String [] array;
		String cuenta;
		int cont=0;
		cadena=cadena.toLowerCase();
		array=cadena.split(" ");
		for(int i=0;i<array.length;i++){
			if(array[i].equals(palabra)){
				cont=cont+1;
			}
		}
		return cuenta=cont+"";
	}
	public static String menu(String enlace, String palabra) throws IOException{
		
		URL u = new URL (enlace);
		URLConnection uc=u.openConnection();
		String ct = uc.getContentType();
		int cl= uc.getContentLength();
		if (ct.startsWith("text/") || cl==-1){
			return contar(texto(enlace),palabra);
		}else{
			if(ct.startsWith("image/")||cl==-1){
				if(ct.endsWith(".gif")){
					capturarImg(enlace);
					return "gif guardado";
					
				}else{
					return cl+"";
				}
				
				
			}
		}
		return "No hecho nada";
	}
}
