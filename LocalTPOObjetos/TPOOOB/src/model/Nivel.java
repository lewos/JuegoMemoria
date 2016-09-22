package model;

import java.util.Collection;

public class Nivel {

	private Collection<Pieza> piezas;
	private String nombre;
	private int cantPiezas;

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

}
