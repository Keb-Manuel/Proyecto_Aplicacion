package app_paciente.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class CalendarMouseListener extends MouseAdapter {
    private CalendarController controller;

    public CalendarMouseListener(CalendarController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();

        if (row >= 0 && col >= 0) {
            String fecha = row + "," + col;
            controller.mostrarDetallesCita(fecha);
        }
    }
}