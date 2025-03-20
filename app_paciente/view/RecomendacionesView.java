package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class RecomendacionesView extends JPanel {
    private JPanel pnlPrincipal;
    private JPanel pnlElementos;

    public RecomendacionesView() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BorderLayout());

        pnlElementos = new JPanel();
        pnlElementos.setLayout(new GridLayout(0, 1, 0, 5));

        JScrollPane scroll = new JScrollPane(pnlElementos);
        pnlPrincipal.add(scroll, BorderLayout.CENTER);

        add(pnlPrincipal, BorderLayout.CENTER);
    }

    public void agregarRecomendacion(String titulo, String descripcion) {
        JLabel lblTitulo = new JLabel(titulo);
        JLabel lblDescripcion = new JLabel(descripcion);

        JPanel panelRecomendacion = new JPanel();
        panelRecomendacion.setLayout(new GridLayout(2, 1));
        panelRecomendacion.add(lblTitulo);
        panelRecomendacion.add(lblDescripcion);

        pnlElementos.add(panelRecomendacion);
        pnlElementos.revalidate();
        pnlElementos.repaint();
    }
}