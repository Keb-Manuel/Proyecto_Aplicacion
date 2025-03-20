package app_paciente.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class CalendarView extends JPanel {
    private JTable calendarTable;
    private DefaultTableModel calendarModel;
    private JButton btnSolicitar;

    public CalendarView() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        String[] columnNames = { "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom" };
        calendarModel = new DefaultTableModel(null, columnNames);
        calendarTable = new JTable(calendarModel);

        JScrollPane calendarScroll = new JScrollPane(calendarTable);
        add(calendarScroll, BorderLayout.CENTER);

        btnSolicitar = new JButton("Solicitar cita");
        add(btnSolicitar, BorderLayout.SOUTH);
    }

    public JButton getBtnSolicitar() {
        return btnSolicitar;
    }

    public void agregarDia(int dia) {
        calendarModel.addRow(new Object[] { dia });
    }
}