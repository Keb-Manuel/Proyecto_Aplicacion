package app_paciente.controller;

import javax.swing.*;

import app_paciente.view.ChatView;
import app_paciente.view.ContainerGenBaseView;
import app_paciente.view.InicioSesionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesionController {
    private InicioSesionView view;
    private JFrame frame;

    public InicioSesionController(InicioSesionView view, JFrame frame) {
        this.view = view;
        this.frame = frame;

        view.getAcceptedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = view.getUsuario();
                String contraseña = view.getContraseña();

                if (usuario.equals("admin") && contraseña.equals("123")) {
                    abrirPantallaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(view, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void abrirPantallaPrincipal() {
        frame.getContentPane().removeAll();
        ContainerGenBaseView pantallaPrincipal = new ContainerGenBaseView();
        new ContainerGenBaseController(pantallaPrincipal);
        frame.getContentPane().add(pantallaPrincipal);
        frame.revalidate();
        frame.repaint();
    }
}