package model;

import java.util.Collection;

public class IdentificacionObjetos extends Juego {
	
	public IdentificacionObjetos(Collection<ItemRanking> ranking,String nombre,Collection<Nivel> nivelesObjeto) {
		super(ranking, nombre, nivelesObjeto);
	}
	/**tengo el nivelActual y pregunto a Nivel que valide con el nombrePieza
	 * @nombrePieza
	 * @usuarioActual
	 * */	
	public boolean validarIdentPieza(String nombrePieza, Usuario usuarioActual){	
		Nivel nivelActual=(NivelObjeto)getNivelActual(usuarioActual);
		if( nivelActual.validarNivel(nombrePieza))
		    return this.validarNivel(usuarioActual);
		return false;
	}


	/*siempre va a dar true pq lo valida validarIdentPieza*/
	@Override
	public boolean validarNivel(Usuario usuarioActual) {
		return true;
	}

}
