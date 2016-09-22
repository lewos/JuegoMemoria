package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.IdentificacionObjetos;
import model.Juego;
import model.Memoria;
import model.Pieza;
import model.Usuario;

public class ControladorDos {
	
	private List<Usuario> usuarios;
	private List<Juego> juegos;
	private List<Pieza> piezas;
	private Usuario usuarioActual;
	
	public ControladorDos(){
		this.usuarios = new ArrayList<Usuario>();
		this.juegos = new ArrayList<Juego>();
		this.piezas = new ArrayList<Pieza>();
		this.juegos.add(new IdentificacionObjetos());
		this.juegos.add(new Memoria());
	}
	
	public void altaUsuario(String nombre) {
		if (buscarUsuario(nombre) == null) 
			this.usuarios.add(new Usuario(nombre));
	}
	
	private Usuario buscarUsuario(String nombre) {
		Usuario result = null;
		Iterator<Usuario> it = usuarios.iterator();
		while (result == null && it.hasNext()) {
			Usuario u = it.next();
			if (nombre.equals(u.getNombre())) {
				result = u;
			}
		}
		return result;
	}
	public void bajaUsuario(String nombre) {
		this.usuarios.remove(buscarUsuario(nombre));
	}
	
	public void modificacionFechaUsuario(Date fechaNac){
		this.usuarioActual.setFechaNac(fechaNac);
	}
	
	public boolean validarUsuario(String nombreUsuario) {
		return buscarUsuario(nombreUsuario) != null;
	}
	
	public String[] obtenerNombreJuegos() {
		String[] result = new String[this.juegos.size()];
		for (int i = 0; i < this.juegos.size(); i++) {
			result[i] = this.juegos.get(i).getNombre();
		}
		return result;
	}
	/*asumo que c/usuario tiene un nivel en cada juego, en el que se quedo
	 * o si es un nuevo ususario en el nivel 1 de c/juego
	 * por eso cargarNivel no lleva parametros
	 * 
	 * 
	 * No me queda claro que tengo que devolver, pq deveria dar un nivel de un juego de usuarioActual
	 * pero el MVC no me deja darle objetos del modelo a la vista
	 * */
	public  List<String> cargarNivel(String nombreJuego){
		
		List<String> pathPiezas = new ArrayList<String>(); 
		
		/*1ero
		 * instancio el juego que me pasan por String
		 */
		
		Juego juegoActual = null;
		Iterator<Juego> it = juegos.iterator();
		while (juegoActual == null && it.hasNext()) {
			Juego u = it.next();
			if (nombreJuego.equals(u.getNombre())) {
				juegoActual = u;
			}
		}	
		/*obtengo las piezas del nivel y la cantidad del mismo*/
		Collection<Pieza> piezasNivel = juegoActual.getPiezasNivelDelUsuario(usuarioActual);
		int cantPiezas= juegoActual.getCantPiezasNivelDelUsuario(usuarioActual);
		
		/*y ahora paso el path de las piezas ? y la cantidad las tengo que pasar al view?*/
		Iterator<Pieza> itPiezas= piezasNivel.iterator();
		Iterator<String> itPath = pathPiezas.iterator();
		while(piezasNivel==null && itPiezas.hasNext()&& itPath.hasNext()&& cantPiezas!=0){
			Pieza p = itPiezas.next();
			pathPiezas.add(p.getPath());
			cantPiezas--;
		}
		
		return pathPiezas;
		
	}
	
	
}
