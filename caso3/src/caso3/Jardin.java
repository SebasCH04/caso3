package caso3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Jardin {
	String NombreJardin;
	public List<Plantas> Plantas;
	String Estacion;
	Timer timer = new Timer("Timer");
	
	public void AgregarPlanta(Plantas Planta) {
		if (Plantas == null) {
			Plantas = new ArrayList<Plantas>();
		}
		Plantas.add(Planta);
	}
	
	public Jardin(String nombreJardin) {
		super();
		NombreJardin = nombreJardin;
	}
	
	public Jardin() {
		
	}
	
	public void RegarPlantas() {
		for (int i = 0; i < this.Plantas.size(); i++) {
			if (this.Plantas.get(i) != null) {
				this.Plantas.get(i).PorcentajeAgua += 10;
				if (this.Plantas.get(i).PorcentajeAgua > 100) {
		    		  this.Plantas.get(i).PorcentajeAgua = (float) 100;
		    	}
				if (this.Plantas.get(i).PorcentajeAgua < 0) {
		    		  this.Plantas.get(i).PorcentajeAgua = (float) 0;
		    	}
			}
		}
	}
	
	public void AbonarPlantas() {
		for (int i = 0; i < this.Plantas.size(); i++) {
			if (this.Plantas.get(i) != null) {
				this.Plantas.get(i).PorcentajeAbono += 10;
				if (this.Plantas.get(i).PorcentajeAbono > 100) {
		    		  this.Plantas.get(i).PorcentajeAbono = (float) 100;
		    	  }
			}
		}
	}
	
	public String getNombreJardin() {
		return NombreJardin;
	}
	
	public void setNombreJardin(String nombreJardin) {
		NombreJardin = nombreJardin;
	}
	
	public List<Plantas> getPlantas() {
		return Plantas;
	}
	
	public void setPlantas(List<Plantas> plantas) {
		Plantas = plantas;
	}
	
	public String getEstacion() {
		return Estacion;
	}
	
	public void setEstacion(String estacion) {
		Estacion = estacion;
	}
	
	public void ControlTiempo() {
		Jardin jardin = this;
		TimerTask task = new TimerTask() {
	        public void run() {
	        	for (int i = 0; i < jardin.Plantas.size(); i++) {
	        		
	        		jardin.Plantas.get(i).TiempoTranscurrido += 1;
	        		
	        		if (jardin.Plantas.get(i).TiempoTranscurrido % 30 == 0) {
	        			jardin.Plantas.get(i).Edad += 1;
	        			
	        			int Indice = jardin.Plantas.get(i).getCicloVida().indexOf(jardin.Plantas.get(i).EtapaActual);
	        			
	        			if (jardin.Plantas.get(i).getCicloVida().size() - 1 > Indice) {
	        				if (jardin.Plantas.get(i).getCicloVida().size() > 1) {
	        					jardin.Plantas.get(i).EtapaActual = jardin.Plantas.get(i).getCicloVida().get(Indice + 1);
	        				}
	        			}
	        		}
	        		
	    			if (jardin.Plantas.get(i) != null) {
	    				  Random rand = new Random();
	    			      int upperbound = 11;
	    			      int int_random = rand.nextInt(upperbound);
	    			      
	    			      if (int_random % 2 == 0) {
	    			    	  jardin.Plantas.get(i).PorcentajeSol += 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeSol > 100) {
	    			    		  jardin.Plantas.get(i).PorcentajeSol = (float) 100;
	    			    	  }
	    			      }
	    			      else {
	    			    	  jardin.Plantas.get(i).PorcentajeSol -= 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeSol < 0) {
	    			    		  jardin.Plantas.get(i).PorcentajeSol = (float) 0;
	    			    	  }
	    			      }
	    			      if (jardin.Plantas.get(i).PorcentajeSol > 80) {
	    			    	  jardin.Plantas.get(i).PorcentajeAgua -= (float) 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeAgua < 0) {
	    			    		  jardin.Plantas.get(i).PorcentajeAgua = (float) 0;
	    			    	}
	    			      }
	    			      if ((80 > jardin.Plantas.get(i).PorcentajeSol) & (jardin.Plantas.get(i).PorcentajeSol > 60)) {
	    			    	  jardin.Plantas.get(i).PorcentajeAgua -= (float) 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeAgua < 0) {
	    			    		  jardin.Plantas.get(i).PorcentajeAgua = (float) 0;
	    			    	}
	    			      }
	    			      if (jardin.Plantas.get(i).PorcentajeSol > 80) {
	    			    	  jardin.Plantas.get(i).PorcentajeAbono -= (float) 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeAbono < 0) {
	    			    		  jardin.Plantas.get(i).PorcentajeAbono = (float) 0;
	    			    	}
	    			      }
	    			      if ((80 > jardin.Plantas.get(i).PorcentajeSol) & (jardin.Plantas.get(i).PorcentajeSol > 60)) {
	    			    	  jardin.Plantas.get(i).PorcentajeAbono -= (float) 5;
	    			    	  if (jardin.Plantas.get(i).PorcentajeAbono < 0) {
	    			    		  jardin.Plantas.get(i).PorcentajeAbono = (float) 0;
	    			    	}
	    			      }
	    			      if (jardin.Plantas.get(i).PorcentajeSol == 100) {
	    			    	  jardin.Plantas.get(i).PorcentajeSol = (float) 50;
	    			      }
	    			      if (jardin.Plantas.get(i).PorcentajeSol == 0) {
	    			    	  jardin.Plantas.get(i).PorcentajeSol = (float) 50;
	    			      }
	    			      if ((jardin.Plantas.get(i).PorcentajeAgua <= 25) & (jardin.Plantas.get(i).PorcentajeAgua <= 5)) {
	    			    	  jardin.Plantas.get(i).Estado = "Seca";
	    			      }
	    			      if ((jardin.Plantas.get(i).PorcentajeAgua < 25) & (jardin.Plantas.get(i).PorcentajeAgua < 75)) {
	    			    	  jardin.Plantas.get(i).Estado = "Normal";
	    			      }
	    			      if ((jardin.Plantas.get(i).PorcentajeAgua >= 75) & (jardin.Plantas.get(i).PorcentajeAgua <= 95)) {
	    			    	  jardin.Plantas.get(i).Estado = "Humeda";
	    			      }
	    			      if (jardin.Plantas.get(i).PorcentajeAgua >= 95 || jardin.Plantas.get(i).PorcentajeAbono >= 95) {
	    			    	  jardin.Plantas.get(i).Estado = "Muerta";
	    			    	  jardin.Plantas.get(i).PorcentajeAgua = (float) 100;
	    			    	  jardin.Plantas.get(i).PorcentajeAbono = (float) 100;
	    			      }
	    			      
	    			      
	    			}
	    		}
	        }
	    };
	    
	    long delay = 1000;
	    timer.scheduleAtFixedRate(task, delay, 1000);
	}
	
}
