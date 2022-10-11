package caso3;

public class TipoPlanta extends Plantas {
	String VelCrecimiento;
	String CantidaAgCrecer;
	String CantidaAgSobrevivir;
	String CantidaAgMorir;
	String CantiAbonoFlorear;
	String CantiAbonoFruto;
	String CanSolSobrevivir;
	String CanSolCreecer;
	String CantSolMorir;
	String CantSolActual;
	String CantAgActual;
	String CicloDeVida;
	
	public TipoPlanta(String velCrecimiento, String cantidaAgCrecer, String cantidaAgSobrevivir, String cantidaAgMorir,
			String cantiAbonoFlorear, String cantiAbonoFruto, String canSolSobrevivir, String canSolCreecer,
			String cantSolMorir, String cantSolActual, String cantAgActual, String cicloDeVida) {
		super();
		VelCrecimiento = velCrecimiento;
		CantidaAgCrecer = cantidaAgCrecer;
		CantidaAgSobrevivir = cantidaAgSobrevivir;
		CantidaAgMorir = cantidaAgMorir;
		CantiAbonoFlorear = cantiAbonoFlorear;
		CantiAbonoFruto = cantiAbonoFruto;
		CanSolSobrevivir = canSolSobrevivir;
		CanSolCreecer = canSolCreecer;
		CantSolMorir = cantSolMorir;
		CantSolActual = cantSolActual;
		CantAgActual = cantAgActual;
		CicloDeVida = cicloDeVida;
	}
	
	public TipoPlanta() {
		
	}
	
	public String getVelCrecimiento() {
		return VelCrecimiento;
	}
	
	public void setVelCrecimiento(String velCrecimiento) {
		VelCrecimiento = velCrecimiento;
	}
	
	public String getCantidaAgCrecer() {
		return CantidaAgCrecer;
	}
	
	public void setCantidaAgCrecer(String cantidaAgCrecer) {
		CantidaAgCrecer = cantidaAgCrecer;
	}
	
	public String getCantidaAgSobrevivir() {
		return CantidaAgSobrevivir;
	}
	
	public void setCantidaAgSobrevivir(String cantidaAgSobrevivir) {
		CantidaAgSobrevivir = cantidaAgSobrevivir;
	}
	
	public String getCantidaAgMorir() {
		return CantidaAgMorir;
	}
	
	public void setCantidaAgMorir(String cantidaAgMorir) {
		CantidaAgMorir = cantidaAgMorir;
	}
	
	public String getCantiAbonoFlorear() {
		return CantiAbonoFlorear;
	}
	
	public void setCantiAbonoFlorear(String cantiAbonoFlorear) {
		CantiAbonoFlorear = cantiAbonoFlorear;
	}
	
	public String getCantiAbonoFruto() {
		return CantiAbonoFruto;
	}
	
	public void setCantiAbonoFruto(String cantiAbonoFruto) {
		CantiAbonoFruto = cantiAbonoFruto;
	}
	
	public String getCanSolSobrevivir() {
		return CanSolSobrevivir;
	}
	
	public void setCanSolSobrevivir(String canSolSobrevivir) {
		CanSolSobrevivir = canSolSobrevivir;
	}
	
	public String getCanSolCreecer() {
		return CanSolCreecer;
	}
	
	public void setCanSolCreecer(String canSolCreecer) {
		CanSolCreecer = canSolCreecer;
	}
	
	public String getCantSolMorir() {
		return CantSolMorir;
	}
	
	public void setCantSolMorir(String cantSolMorir) {
		CantSolMorir = cantSolMorir;
	}
	
	public String getCantSolActual() {
		return CantSolActual;
	}
	
	public void setCantSolActual(String cantSolActual) {
		CantSolActual = cantSolActual;
	}
	
	public String getCantAgActual() {
		return CantAgActual;
	}
	
	public void setCantAgActual(String cantAgActual) {
		CantAgActual = cantAgActual;
	}
	
	public String getCicloDeVida() {
		return CicloDeVida;
	}
	
	public void setCicloDeVida(String cicloDeVida) {
		CicloDeVida = cicloDeVida;
	}
	
}
