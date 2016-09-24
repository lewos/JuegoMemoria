package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controlador;

public class LoginFrame extends BaseViewFrame {

	private static final long serialVersionUID = -8820079485940620138L;
	private final static String DEFAULT_LOGIN_MSG = "Ingrese su nombre de usuario:";
	private final static String DEFAULT_LOGIN_BUTTON_MSG = "Login";
	private final static String DEFAULT_NEW_USER_BUTTON_MSG = "Nuevo Usuario";
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
		loginButton.setBounds(160, 60, 100, 30);
		loginButton.addActionListener(new LoginButtonActionListener(this));

		JButton newUserButton = new JButton(DEFAULT_NEW_USER_BUTTON_MSG);
		newUserButton.setBounds(260, 60, 130, 30);
		newUserButton.addActionListener(new NewUserActionListener(this));

		add(usuarioLabel);
		add(this.usuarioField);
		add(loginButton);
		add(newUserButton);
	}

	public class LoginButtonActionListener implements ActionListener {

		private LoginFrame loginFrame;

		public LoginButtonActionListener(LoginFrame loginFrame) {
			this.loginFrame = loginFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (loginFrame.usuarioField.getText() != null && !loginFrame.usuarioField.getText().isEmpty()) {
				boolean loginOk = controller.validarUsuario(loginFrame.usuarioField.getText());
				if (!loginOk) {
					JLabel usuarioNoExisteLabel = new JLabel("El usuario no existe!");
					usuarioNoExisteLabel.setBounds(20, 100, 200, 20);
					loginFrame.add(usuarioNoExisteLabel);
				} else {
					//deberiamos ir al menu ppal
				}
			}

		}

	}

	public class NewUserActionListener implements ActionListener {
		private LoginFrame loginFrame;

		public NewUserActionListener(LoginFrame loginFrame) {
			this.loginFrame = loginFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			NuevoUsuarioFrame nuf = new NuevoUsuarioFrame(controller);
			this.loginFrame.setVisible(false);
			nuf.setVisible(true);
		}

	}
}
