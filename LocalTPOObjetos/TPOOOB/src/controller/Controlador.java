package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.ValidationException;
import model.IdentificacionObjetos;
import model.Juego;
import model.Memoria;
import model.Usuario;

public class Controlador {

	private List<Usuario> usuarios;
	private List<Juego> juegos;
	private Usuario usuarioActual;

	public Controlador() {
		this.usuarios = new ArrayList<Usuario>();
		this.juegos = new ArrayList<Juego>();
		this.juegos.add(new IdentificacionObjetos());
		this.juegos.add(new Memoria());
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
     /**/                                     /* throws ValidationException   esto no se va , tampoco lo entiendo*/
	public void altaUsuario(String nombre) throws ValidationException {
		if (buscarUsuario(nombre) == null) {
			this.usuarios.add(new Usuario(nombre));
		} else {
			throw new ValidationException("El usuario ya existe");
		}
	}
    /**/
	public void bajaUsuario(String nombre) {
		this.usuarios.remove(buscarUsuario(nombre));
	}
    /**/
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

}
