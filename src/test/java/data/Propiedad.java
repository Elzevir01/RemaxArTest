package data;

public class Propiedad {
	private String descripcion;
	private String superficieTotal;
	private String superficieCubierta;
	private String baños;
	private String aptoProfecional;
	private String pisosPropiedad;
	private String expensas;
	private String titulo;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPrecioDolar() {
		return precioDolar;
	}
	public void setPrecioDolar(String precioDolar) {
		this.precioDolar = precioDolar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getSuperficieTotal() {
		return superficieTotal;
	}
	public void setSuperficieTotal(String superficieTotal) {
		this.superficieTotal = superficieTotal;
	}
	public String getSuperficieCubierta() {
		return superficieCubierta;
	}
	public void setSuperficieCubierta(String superficieCubierta) {
		this.superficieCubierta = superficieCubierta;
	}
	public String getBaños() {
		return baños;
	}
	public void setBaños(String baños) {
		this.baños = baños;
	}
	public String getAptoProfecional() {
		return aptoProfecional;
	}
	public void setAptoProfecional(String aptoProfecional) {
		this.aptoProfecional = aptoProfecional;
	}
	public String getPisosPropiedad() {
		return pisosPropiedad;
	}
	public void setPisosPropiedad(String pisosPropiedad) {
		this.pisosPropiedad = pisosPropiedad;
	}
	public String getExpensas() {
		return expensas;
	}
	public void setExpensas(String expensas) {
		this.expensas = expensas;
	}
	String precioDolar;
	public Propiedad(String titulo, String precioDolar, String descripcion, String superficieTotal,
			String superficieCubierta, String baños, String aptoProfecional, String pisosPropiedad, String expensas) {
		super();
		this.titulo = titulo;
		this.precioDolar = precioDolar;
		this.descripcion = descripcion;
		this.superficieTotal = superficieTotal;
		this.superficieCubierta = superficieCubierta;
		this.baños = baños;
		this.aptoProfecional = aptoProfecional;
		this.pisosPropiedad = pisosPropiedad;
		this.expensas = expensas;
	}
	public Propiedad() {
		
	}
	
}
