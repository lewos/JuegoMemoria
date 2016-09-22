package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.Controlador;

public abstract class BaseViewFrame extends JFrame {

	private static final long serialVersionUID = 2492041154394947374L;
	protected Controlador controller;

	public BaseViewFrame(Controlador controller) {
		this.controller = controller;
		this.setBounds(100, 100, 500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Juegos TPO");
		this.setLayout(null);
	}
}
