package model;

import java.util.Collection;
import java.util.Iterator;

public abstract class Juego {

	protected Collection<ItemRanking> ranking;
	protected String nombre;
	protected Collection<Nivel> niveles;

	public Juego(Collection<ItemRanking> ranking,String nombre,Collection<Nivel> niveles){
		this.ranking=ranking;
		this.nombre=nombre;
		this.niveles= niveles;
	}

	public Collection<Nivel> getNiveles() {
		return this.niveles;
	}

	public Collection<ItemRanking> getRanking() {
		return ranking;
	}

	public void setRanking(Collection<ItemRanking> ranking) {
		this.ranking = ranking;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Collection<Pieza> getPiezasNivelDelUsuario(Usuario usuarioActual){
		ItemRanking itRanking =buscarItemRankingUsuarioActual(usuarioActual);    
		return itRanking.getNivelDondeQuedo().getPiezas();
	}
	
	public int getCantPiezasNivelDelUsuario(Usuario usuarioActual){
        ItemRanking itRanking =buscarItemRankingUsuarioActual(usuarioActual);
		return itRanking.getNivelDondeQuedo().getCantPiezas();
	}
	
	/*con esto obtengo el itemRanking del usuarioActual*/
	private ItemRanking buscarItemRankingUsuarioActual(Usuario usuarioActual){
		ItemRanking result= null;	
	    Iterator<ItemRanking> itRanking = ranking.iterator();
			while (result == null && itRanking.hasNext()) {
				ItemRanking u = itRanking.next();
					if (u.getUsuario().equals(usuarioActual)) {
					result = u;
				}	
			}
			return result;
	}
	/*este no se si va en el diagrama pq es protected*/
	protected Nivel getNivelActual(Usuario usuarioActual){
		ItemRanking itemRank = buscarItemRankingUsuarioActual(usuarioActual);
		Nivel nivelActual=itemRank.getNivelDondeQuedo();
		return nivelActual;
	}
	
	public abstract boolean validarNivel(Usuario usuarioActual);

}
