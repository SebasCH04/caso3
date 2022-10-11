package caso3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Etapas {
	
	public String Nombre;
	public int duracionMeses;
	public boolean daFruto;
	public boolean muere;
	public boolean florece;
	public boolean crece;
	public int crecePorcentaje;
	public String URL;
	
	
	public Etapas(String nombre, int duracionMeses, boolean daFruto, boolean muere, boolean florece, boolean crece,
			int crecePorcentaje, String URL) {
		super();
		Nombre = nombre;
		this.duracionMeses = duracionMeses;
		this.daFruto = daFruto;
		this.muere = muere;
		this.florece = florece;
		this.crece = crece;
		this.crecePorcentaje = crecePorcentaje;
		this.URL = URL;
	}
	
	public Etapas() {
		
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	
	public int getDuracionMeses() {
		return duracionMeses;
	}
	
	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}
	
	public boolean getDaFruto() {
		return daFruto;
	}
	
	public void setDaFruto(boolean daFruto) {
		this.daFruto = daFruto;
	}
	
	public boolean getMuere() {
		return muere;
	}
	
	public void setMuere(boolean muere) {
		this.muere = muere;
	}
	
	public boolean getFlorece() {
		return florece;
	}
	
	public void setFlorece(boolean florece) {
		this.florece = florece;
	}
	
	public boolean getCrece() {
		return crece;
	}
	
	public void setCrece(boolean crece) {
		this.crece = crece;
	}
	
	public int getCrecePorcentaje() {
		return crecePorcentaje;
	}
	
	public void setCrecePorcentaje(int crecePorcentaje) {
		this.crecePorcentaje = crecePorcentaje;
	}
	
	public ArrayList<Etapas> leerCilosVida() {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Etapas> etapas = new ArrayList<Etapas>();
		Object obj;
		try {
			obj = jsonParser.parse(new FileReader("C:\\Users\\sebas\\eclipse-workspace\\caso3\\etapas.json"));
			JSONObject jsonObject = (JSONObject)obj;
			JSONArray subjects = (JSONArray)jsonObject.get("etapas");
			subjects.forEach(emp -> etapas.add(parseEmployeeObject((JSONObject) emp)));

		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
       
        return etapas;

	}
	
	 private static Etapas parseEmployeeObject(JSONObject etapaJSON) 
	    {
		 	Etapas nuevaEtapa = new Etapas();
	        String Nombre = (String) etapaJSON.get("Nombre");    
	        
	        nuevaEtapa.Nombre = Nombre;
	        Long DuracionEnMeses = (Long) etapaJSON.get("DuracionEnMeses"); 
	        nuevaEtapa.duracionMeses = Integer.parseInt(DuracionEnMeses.toString());
	        boolean DaFruto = (boolean) etapaJSON.get("DaFruto"); 
	        nuevaEtapa.daFruto = DaFruto;
	        boolean Muere = (boolean) etapaJSON.get("Muere"); 
	        nuevaEtapa.muere = Muere;
	        boolean Florece = (boolean) etapaJSON.get("Florece"); 
	        nuevaEtapa.florece = Florece;
	        boolean Crece = (boolean) etapaJSON.get("Crece"); 
	        nuevaEtapa.crece = Crece;
	        Long CrecePorcentaje = (Long) etapaJSON.get("CrecePorcentaje"); 
	        nuevaEtapa.crecePorcentaje = Integer.parseInt(CrecePorcentaje.toString());
	        String URL = (String) etapaJSON.get("URL"); 
	        nuevaEtapa.URL = URL;

	        return nuevaEtapa;
	    }

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}


}
