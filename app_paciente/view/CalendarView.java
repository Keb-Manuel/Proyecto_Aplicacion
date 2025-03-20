package app_paciente.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import Style.EstilosUI;

public class CalendarView extends JPanel {
    private JTable calendarTable;
    private JButton btnSolicitar;
    private JButton btnCancelar;
    private JButton btnReprogramar;
    private JPanel sidePanel;
    private JTextArea infoArea;
    private JList<String> listaDiasDisponibles;
    private DefaultListModel<String> listModel;

    public CalendarView() {
        this.setLayout(new BorderLayout());
        this.listModel = new DefaultListModel<>();
        this.listaDiasDisponibles = new JList<>(listModel);
        this.infoArea = new JTextArea();
        this.infoArea.setEditable(false);

        // Inicializar la tabla del calendario
        this.calendarTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(calendarTable); // Asignar la tabla al JScrollPane
        scrollPane.setOpaque(false);

        btnSolicitar = new JButton("Solicitar cita");
        btnCancelar = new JButton("Cancelar");
        btnReprogramar = new JButton("Reprogramar");

        sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(250, 150));

        JPanel panelFechas = new JPanel(new BorderLayout());
        panelFechas.add(new JLabel("Fechas disponibles"), BorderLayout.NORTH);
        panelFechas.add(new JScrollPane(listaDiasDisponibles), BorderLayout.CENTER);

        sidePanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        sidePanel.add(panelFechas, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCancelar);
        panelBotones.add(btnReprogramar);
        sidePanel.add(panelBotones, BorderLayout.SOUTH);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(btnSolicitar, BorderLayout.SOUTH);

        this.add(panelPrincipal, BorderLayout.CENTER);
        this.add(sidePanel, BorderLayout.EAST);

        EstilosUI.aplicarEstiloPanelPrincipal(sidePanel);
        EstilosUI.aplicarEstiloPanelPrincipal(panelPrincipal);
        // EstilosUI.aplicarBotonGeneral(btnCancelar);
        // EstilosUI.aplicarBotonGeneral(btnReprogramar);
        // EstilosUI.aplicarBotonGeneral(btnSolicitar);
    }

    public JTable getCalendarTable() {
        return calendarTable;
    }

    public JButton getBtnSolicitar() {
        return btnSolicitar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnReprogramar() {
        return btnReprogramar;
    }

    public JTextArea getInfoArea() {
        return infoArea;
    }

    public JList<String> getListaDiasDisponibles() {
        return listaDiasDisponibles;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
}
