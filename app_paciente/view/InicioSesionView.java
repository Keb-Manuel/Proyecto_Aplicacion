package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class InicioSesionView extends JPanel {
    private JTextField usuario;
    private JPasswordField contraseña;
    private JButton accepted;
    private JButton olvPassword;

    public InicioSesionView() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        usuario = new JTextField(20);
        contraseña = new JPasswordField(20);
        accepted = new JButton("Aceptar");
        olvPassword = new JButton("Olvidé mi contraseña");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Usuario:"), gbc);

        gbc.gridy = 1;
        add(usuario, gbc);

        gbc.gridy = 2;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridy = 3;
        add(contraseña, gbc);

        gbc.gridy = 4;
        add(accepted, gbc);

        gbc.gridy = 5;
        add(olvPassword, gbc);
    }

    public JButton getAcceptedButton() {
        return accepted;
    }

    public JButton getOlvPasswordButton() {
        return olvPassword;
    }

    public String getUsuario() {
        return usuario.getText();
    }

    public String getContraseña() {
        return new String(contraseña.getPassword());
    }
}