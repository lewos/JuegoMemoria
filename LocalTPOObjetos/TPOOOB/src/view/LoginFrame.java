package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import exception.ValidationException;

import controller.Controlador;

public class LoginFrame extends BaseViewFrame {

	private static final long serialVersionUID = -8820079485940620138L;
	private final static String DEFAULT_LOGIN_MSG = "Ingrese su nombre de usuario:";
	private final static String DEFAULT_LOGIN_BUTTON_MSG = "Aceptar";
	private JTextField usuarioField;

	public LoginFrame(Controlador controller) {
		super(controller);
		this.init();
	}

	private void init() {
		JLabel usuarioLabel = new JLabel(DEFAULT_LOGIN_MSG);
		usuarioLabel.setBounds(20, 20, 200, 20);
		this.usuarioField = new JTextField();
		this.usuarioField.setBounds(220, 20, 200, 20);
		JButton loginButton = new JButton(DEFAULT_LOGIN_BUTTON_MSG);
		loginButton.setBounds(320, 60, 100, 30);
		loginButton.addActionListener(new LoginButtonActionListener(this));
		add(usuarioLabel);
		add(this.usuarioField);
		add(loginButton);
	}

	public class LoginButtonActionListener implements ActionListener {

		private LoginFrame loginFrame;

		public LoginButtonActionListener(LoginFrame loginFrame) {
			this.loginFrame = loginFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (loginFrame.usuarioField.getText() != null && !loginFrame.usuarioField.getText().isEmpty()) {
				try {
					controller.altaUsuario(loginFrame.usuarioField.getText());
					// Login exitoso, redirigir al menu ppal
					
				} catch (ValidationException e1) {
					// TODO: Debemos mostrar un mensaje de error en la pantalla
					// con el mensaje de le ex
					e1.printStackTrace();
				}
			}

		}

	}
}
