import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author diego
 *
 */
public class Operaciones 
{
	/*
	 * Código extraido de la hoja de trabajo número 4 
	 * Lee el archivo
	 */
	public String[] extractText(String fileName){
        StringBuilder contentBuilder = new StringBuilder();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get(fileName),
                    StandardCharsets.UTF_8);
            lines.forEach(s ->contentBuilder.append(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        String calculation = contentBuilder.toString();
        String[] onlySymbols = calculation.split("\\|");
        
        return onlySymbols;
    }
	/*
	 * Factory para elegir implementacion del Map 
	 */
	public Map selecMap(int op) 
	{
		if(op == 1)
			return new HashMap<String, String>();
		else if(op == 2)
			return new TreeMap<String, String>();
		else
			return new LinkedHashMap<String, String>();
		
	}
	
	public boolean existe(String search, String[] myList) 
	{
		for(String str: myList) {
		    if(str.trim().contains(search))
		       return true;
		}
		return false;
	}

	
	
	
	

}
