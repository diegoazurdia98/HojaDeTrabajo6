
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author diego
 *
 */
public class Main 
{

	/**
	 * @param args
	 */
	
	
	
	
	public static void main(String[] args) 
	{
		//Variables y objetos
		String Archivo = "";
		Scanner teclado = new Scanner(System.in);
		Operaciones o = new Operaciones();
		boolean run = true;
		PrintStream s = System.out;
		
		//Menu para factory
		s.println("¿Que MAP desea utilizar?\n1. HashMap\n2.TreeMap\n3. LinkedHashMap");
		int map = teclado.nextInt();
		Map<String, String> mapa = o.selecMap(map);
		
		//Ingreso del archivo
		s.println("Ingrese el nombre de su archivo: ");
		s.println("Ejemplo: datos.txt");
		Archivo = teclado.next();
		//Se guarda el archivo en una lista
		String[] tienda = o.extractText(Archivo);
		
		s.println("Existen "+tienda.length+" cartas.");
		
		

		int que = 0;
		while(run) 
		{
			//Variables solo dentro del ciclo
			String Carta = "";
			
			//Menu
			s.println("Deseo...\n1. Agregar una carta al deck.\n2. Ver tipo de una carta\n3. Ver mi deck\n4. Ver mi deck ordenado por tipo.\n5. Ver la tienda\n6. Ver la tienda ordenada por tipo.\n7. Salir");
			que = teclado.nextInt();
			
			//Opcion1: agrega una carta al deck del usuario
			if(que == 1) 
			{
				s.println("Ingrese el nombre de la carta a agregar: ");
				Carta = teclado.next();
				
				//Revisa si la carta existe
				//si exite la agrega
				//si no existe da un aviso
				if(o.existe(Carta, tienda))
					mapa.put(Carta, "tipo");
				else
					s.println("La carta que especifico no existe.");
				
			}
			
			//Opcion 2: Regresa el tipo de carta que el usuario ingresa.
			else if(que == 2) 
			{
				s.println("Ingrese el nombre de la carta a agregar: ");
				Carta = teclado.next();
				if(o.existe(Carta, tienda))
				{
					s.println("tipo");
				}
				
			}
			
			//Opcion3: muestra el deck sin ningun orden en especifico
			else if(que == 3) 
			{
				List<String> keys = new ArrayList<String>(mapa.keySet());
			
				if(mapa.size() > 0) 
				{
					for(String key: keys) 
					{
						System.out.println(key + ": " + mapa.get(key));
					}
				}
				else
					s.println("No hay cartas en su deck.");
			}
			
			//Opcion 4: Muestra el deck ordenado por tipo de las cartas
			else if(que == 4) 
			{
				List<String> keys = new ArrayList<String>(mapa.keySet());
			
				if(mapa.size() > 0) 
				{
					for(String key: keys) 
					{
						System.out.println(key + ": " + mapa.get(key));
					}
				}
				else
					s.println("No hay cartas en su deck.");
			}
			
			//Opcion 5: muestra todas las cartas que existen sin ningun orden en especifico
			else if(que == 5) 
			{	
				if(tienda.length > 1) 
				{
					for(int i = 0; i < tienda.length; i++) 
					{
						s.println(tienda[i]);
					}
				}
			}
			
			//Opcion 6: muestra todas las cartas ordenadas por tipo.
			else if(que == 6) 
			{	
				if(tienda.length > 1) 
				{
					for(int i = 0; i < tienda.length; i++) 
					{
						s.println(tienda[i]);
					}
				}
			}
			else
			{
				run = false;
				s.println("Adios.");
			}
			
			
			
		}
		
		
		teclado.close();
	}

}
