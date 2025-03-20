package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class HistorialMedicoView extends JPanel {
    private JPanel container;
    private JScrollPane scroll;

    public HistorialMedicoView() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        container = new JPanel();
        container.setLayout(new GridLayout(0, 1, 0, 5));
        scroll = new JScrollPane(container);
        add(scroll, BorderLayout.CENTER);
    }

    public void agregarCita(String cita) {
        JButton botonCita = new JButton(cita);
        container.add(botonCita);
        container.revalidate();
        container.repaint();
    }
}