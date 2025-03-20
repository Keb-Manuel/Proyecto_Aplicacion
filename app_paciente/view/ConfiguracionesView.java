package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class ConfiguracionesView extends JPanel {
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JPasswordField txtContraseña;
    private JButton btnGuardar;

    public ConfiguracionesView() {
        init();
    }

    private void init() {
        setLayout(new GridLayout(5, 2));

        txtCorreo = new JTextField();
        txtTelefono = new JTextField();
        txtDireccion = new JTextField();
        txtContraseña = new JPasswordField();
        btnGuardar = new JButton("Guardar");

        add(new JLabel("Correo electrónico:"));
        add(txtCorreo);
        add(new JLabel("Número telefónico:"));
        add(txtTelefono);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Contraseña:"));
        add(txtContraseña);
        add(new JLabel());
        add(btnGuardar);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }
}