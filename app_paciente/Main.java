package app_paciente;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import app_paciente.controller.InicioSesionController;
import app_paciente.view.InicioSesionView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inicio de Sesión");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            InicioSesionView inicioSesionView = new InicioSesionView();
            new InicioSesionController(inicioSesionView, frame);

            frame.getContentPane().add(inicioSesionView);
            frame.setVisible(true);
        });
    }
}