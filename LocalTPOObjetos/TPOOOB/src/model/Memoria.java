package model;

import java.util.Collection;

public class Memoria extends Juego {
	
	public Memoria(Collection<ItemRanking> ranking,String nombre,Collection<Nivel> nivelesMemoria){
		super(ranking, nombre, nivelesMemoria);
	}
	
	public boolean validarPar(String nomPiezaSel1,String nomPiezaSel2,Usuario usuarioActual){
		// esto de hacer un cast no se si se adapta al mvc
		NivelMemoria nivelActual=(NivelMemoria) getNivelActual(usuarioActual);
		return nivelActual.validarParPiezas(nomPiezaSel1, nomPiezaSel2);
	}
	/**Ve el nivelActual del UsuarioActual y pregunta a Nivel que valide
	 * @UsuarioActual
	 * */
    public boolean validarNivel(Usuario usuarioActual){
		NivelMemoria nivelActual=(NivelMemoria) getNivelActual(usuarioActual);
		String aux = String.valueOf(nivelActual.cantPiezas);
		return nivelActual.validarNivel(aux);

	}
}
