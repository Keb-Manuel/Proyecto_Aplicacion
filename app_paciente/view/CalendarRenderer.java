package app_paciente.view;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CalendarRenderer extends DefaultTableCellRenderer {
    private Map<String, String> citasConfirmadas;

    public CalendarRenderer(Map<String, String> citasConfirmadas) {
        this.citasConfirmadas = citasConfirmadas;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Personalizar la apariencia de las celdas
        setHorizontalAlignment(JLabel.CENTER);

        // Verificar si la fecha tiene una cita registrada
        String fecha = row + "," + column;
        if (citasConfirmadas.containsKey(fecha)) {
            setBackground(new Color(255, 182, 193)); // Rojo claro para citas registradas
        } else if (value != null && !value.toString().isEmpty()) {
            setBackground(new Color(173, 216, 230)); // Azul claro para fechas disponibles
        } else {
            setBackground(Color.WHITE); // Fondo blanco para celdas vacías
        }

        setForeground(Color.BLACK); // Texto negro
        return this;
    }
}