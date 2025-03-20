package app_paciente.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CalendarRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Personalizar la apariencia de las celdas
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);

        return this;
    }
}