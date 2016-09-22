package view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import controller.Controlador;
import enums.Views;

public class MainJuegosUI {

	private Controlador controller;
	private Map<Views, JFrame> viewMap;

	public MainJuegosUI() {
		this.controller = new Controlador();
		this.viewMap = new HashMap<Views, JFrame>();
		this.initUIs();
	}

	private void initUIs() {
		LoginFrame login = new LoginFrame(this.controller);
		login.setVisible(true);

		viewMap.put(Views.LOGIN, login);
	}

	public static void main(String[] args) {
		new MainJuegosUI();
	}
}
