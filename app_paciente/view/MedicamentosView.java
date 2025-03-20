package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class MedicamentosView extends JPanel {
    private JPanel container;
    private JScrollPane scroll;

    public MedicamentosView() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        container = new JPanel();
        container.setLayout(new GridLayout(0, 1, 0, 5));
        scroll = new JScrollPane(container);
        add(scroll, BorderLayout.CENTER);
    }

    public void agregarMedicamento(String nombre, String dosis) {
        JButton botonMedicamento = new JButton(nombre + " - " + dosis);
        container.add(botonMedicamento);
        container.revalidate();
        container.repaint();
    }
}