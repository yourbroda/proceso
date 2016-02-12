package Ejemplos;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ejem4 {

	public static void main(String[] args) {
		String url="";
		try{
			Scanner teclado= new Scanner (System.in);
			url = teclado.nextLine();
			URL u = new URL (url);
			URLConnection uc=u.openConnection();
			String ct = uc.getContentType();
			int cl= uc.getContentLength();
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
			FileOutputStream fout = new FileOutputStream(fich);
			BufferedOutputStream out= new BufferedOutputStream(fout);
			int i;
			while((i = in.read()) !=-1)
				out.write(i);
			out.flush();
			in.close();
			out.close();
		}catch(MalformedURLException e){
			System.out.println("URL erronea: "+ url);
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}

	}

}

