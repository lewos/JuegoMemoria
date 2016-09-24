package model;

import java.util.Collection;

public class NivelObjeto extends Nivel {

	public NivelObjeto(Collection<Pieza> piezas, String nombre, int cantPiezas) {
		super(piezas, nombre, cantPiezas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validarNivel(String nombrePieza) {
		// TODO Auto-generated method stub
		return false;
	}

}
