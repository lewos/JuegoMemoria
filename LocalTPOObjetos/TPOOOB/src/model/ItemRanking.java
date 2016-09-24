package model;

public class ItemRanking {

	private Usuario usuario;
	private Nivel nivelDondeQuedo;
	private int puntaje;

	public ItemRanking(Usuario usuario,Nivel nivelDondeQuedo,int puntaje){
		this.usuario=usuario;
		this.nivelDondeQuedo=nivelDondeQuedo;
		this.puntaje=puntaje;	
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Nivel getNivelDondeQuedo() {
		return nivelDondeQuedo;
	}

	public void setNivelDondeQuedo(Nivel nivelDondeQuedo) {
		this.nivelDondeQuedo = nivelDondeQuedo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
