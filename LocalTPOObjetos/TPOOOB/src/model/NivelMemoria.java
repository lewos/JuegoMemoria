package model;

import java.util.Collection;

public class NivelMemoria extends Nivel {

	public NivelMemoria(Collection<Pieza> piezas, String nombre, int cantPiezas) {
		super(piezas, nombre, cantPiezas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validarNivel(String nombrePieza) {
		// TODO Auto-generated method stub
		return false;
	}

}
