package model;

import java.util.Collection;

public abstract class Nivel {
	
	protected Collection<Pieza> piezas;
	protected String nombre;
	protected int cantPiezas;
	
	public Nivel(Collection<Pieza> piezas,String nombre,int cantPiezas){
		super();
		this.piezas= piezas;
		this.nombre=nombre;
		this.cantPiezas= cantPiezas;
	}

	public Collection<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(Collection<Pieza> piezas) {
		this.piezas = piezas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantPiezas() {
		return cantPiezas;
	}

	public void setCantPiezas(int cantPiezas) {
		this.cantPiezas = cantPiezas;
	}
	
	public abstract boolean validarNivel(String nombrePieza);

}
