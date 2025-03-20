package app_paciente.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
    private JList<String> listaHorasDisponibles;
    private DefaultListModel<String> listModelHoras;

    public CalendarView() {
        this.setLayout(new BorderLayout());
        this.infoArea = new JTextArea();
        this.infoArea.setEditable(false);

        // Inicializar la tabla del calendario
        this.calendarTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar la edición de celdas
            }
        };

        JScrollPane scrollPane = new JScrollPane(calendarTable); // Asignar la tabla al JScrollPane
        scrollPane.setOpaque(false);

        // Configurar el encabezado de la tabla para que sea estático
        calendarTable.setAutoCreateRowSorter(false);
        calendarTable.getTableHeader().setReorderingAllowed(false);

        btnSolicitar = new JButton("Solicitar cita");
        btnSolicitar.setEnabled(false); // Desactivar inicialmente
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setEnabled(false); // Desactivar inicialmente
        btnReprogramar = new JButton("Reprogramar");
        btnReprogramar.setEnabled(false); // Desactivar inicialmente

        sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(250, 150));

        // Lista de horas disponibles
        listModelHoras = new DefaultListModel<>();
        listaHorasDisponibles = new JList<>(listModelHoras);
        JScrollPane scrollHoras = new JScrollPane(listaHorasDisponibles);

        sidePanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        sidePanel.add(scrollHoras, BorderLayout.NORTH);

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

    public JList<String> getListaHorasDisponibles() {
        return listaHorasDisponibles;
    }

    public DefaultListModel<String> getListModelHoras() {
        return listModelHoras;
    }
}