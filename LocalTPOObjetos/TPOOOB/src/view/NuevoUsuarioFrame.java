package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controlador;
import exception.ValidationException;

public class NuevoUsuarioFrame extends BaseViewFrame {

	private static final long serialVersionUID = 8664114819649806499L;
	private final static String USER_NAME = "Nombre de usuario:";
	private final static String FECHA_NAC = "Fecha de nacimiento(dd/mm/yyyy)";
	private final static String BACK = "Volver";
	private final static String ACEPTAR = "Aceptar";
	private JTextField usuarioField;

	public NuevoUsuarioFrame(Controlador controller) {
		super(controller);
		init();
	}

	private void init() {
		JLabel usuarioLabel = new JLabel(USER_NAME);
		usuarioLabel.setBounds(20, 20, 250, 20);
		this.usuarioField = new JTextField();
		this.usuarioField.setBounds(270, 20, 200, 20);

		JLabel fechaNacLabel = new JLabel(FECHA_NAC);
		fechaNacLabel.setBounds(20, 40, 250, 20);
		JTextField fechaNacField = new JTextField();
		fechaNacField.setBounds(270, 40, 200, 20);

		JButton volverButton = new JButton(BACK);
		volverButton.setBounds(160, 60, 100, 30);
		volverButton.addActionListener(new VolverActionListener(this));

		JButton aceptarButton = new JButton(ACEPTAR);
		aceptarButton.setBounds(260, 60, 130, 30);
		aceptarButton.addActionListener(new AceptarActionListener(this));

		add(usuarioLabel);
		add(fechaNacLabel);
		add(usuarioField);
		add(fechaNacField);
		add(volverButton);
		add(aceptarButton);
	}

	private void volver() {
		LoginFrame loginFrame = new LoginFrame(controller);
		this.setVisible(false);
		loginFrame.setVisible(true);
	}

	public class AceptarActionListener implements ActionListener {
		private NuevoUsuarioFrame nuevoUsuarioFrame;

		public AceptarActionListener(NuevoUsuarioFrame nuevoUsuarioFrame) {
			this.nuevoUsuarioFrame = nuevoUsuarioFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (nuevoUsuarioFrame.usuarioField.getText() != null
					&& !nuevoUsuarioFrame.usuarioField.getText().isEmpty()) {
				try {
					controller.altaUsuario(nuevoUsuarioFrame.usuarioField.getText());
					volver();
				} catch (ValidationException ve) {
					JLabel usuarioYaExiste = new JLabel(ve.getMessage());
					usuarioYaExiste.setBounds(20, 100, 200, 20);
					nuevoUsuarioFrame.add(usuarioYaExiste);
				}
			}

		}
	}

	public class VolverActionListener implements ActionListener {
		private NuevoUsuarioFrame nuevoUsuarioFrame;

		public VolverActionListener(NuevoUsuarioFrame nuevoUsuarioFrame) {
			this.nuevoUsuarioFrame = nuevoUsuarioFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			volver();
		}
	}
}
