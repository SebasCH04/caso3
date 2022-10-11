package caso3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Plantas {
	String Nombre;
	String Tamanio;
	String Salud;
	Float IntensidadColor;
	int Edad = 0;
	String Estado;
	ArrayList<Etapas> cicloVida = new ArrayList<Etapas>();
	Float PorcentajeSol = (float) 50;
	Float PorcentajeAgua = (float) 0;
	Float PorcentajeAbono = (float) 0;
	int TiempoTranscurrido = 0;
	Etapas EtapaActual;
	
	public Plantas() {

	}
	
	public Plantas(String Nombre) {
		this.Nombre = Nombre;
		this.Tamanio = "Almacigo";
		this.Salud = "Normal";
		this.IntensidadColor = Float.parseFloat("0");
		this.Estado = "Normal";
		Etapas etapaActual = new Etapas();
		etapaActual.setNombre("Almacigo");
		etapaActual.setDuracionMeses(2);
		etapaActual.setDaFruto(false);
		etapaActual.setMuere(false);
		etapaActual.setFlorece(false);
		etapaActual.setCrece(false);
		etapaActual.setCrecePorcentaje(30);
		this.EtapaActual = etapaActual;
		etapaActual.setURL("C:\\Users\\sebas\\Downloads\\planta_mediana.png");
		this.agregaEtapa(etapaActual);
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getTamanio() {
		return Tamanio;
	}
	
	public void setTamanio(String tamanio) {
		Tamanio = tamanio;
	}
	
	public String getSalud() {
		return Salud;
	}
	
	public void setSalud(String salud) {
		Salud = salud;
	}
	
	public Float getIntensidadColor() {
		return IntensidadColor;
	}
	
	public void setIntensidadColor(Float intensidadColor) {
		IntensidadColor = intensidadColor;
	}
	
	public String getEstado() {
		return Estado;
	}
	
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public void agregaEtapa(Etapas etapa) {
		cicloVida.add(etapa);
	}
	
	public ArrayList<Etapas> getCicloVida(){
		return cicloVida;
	}

	public Float getPorcentajeSol() {
		return PorcentajeSol;
	}

	public void setPorcentajeSol(Float porcentajeSol) {
		PorcentajeSol = porcentajeSol;
	}

	public Float getPorcentajeAgua() {
		return PorcentajeAgua;
	}

	public void setPorcentajeAgua(Float porcentajeAgua) {
		PorcentajeAgua = porcentajeAgua;
	}

	public Float getPorcentajeAbono() {
		return PorcentajeAbono;
	}

	public void setPorcentajeAbono(Float porcentajeAbono) {
		PorcentajeAbono = porcentajeAbono;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public int getTiempoTranscurrido() {
		return TiempoTranscurrido;
	}

	public void setTiempoTranscurrido(int tiempoTranscurrido) {
		TiempoTranscurrido = tiempoTranscurrido;
	}

	public Etapas getEtapaActual() {
		return EtapaActual;
	}

	public void setEtapaActual(Etapas etapaActual) {
		EtapaActual = etapaActual;
	}

}
