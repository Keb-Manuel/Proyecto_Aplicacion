package app_paciente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import app_paciente.model.CalendarModel;
import app_paciente.view.CalendarRenderer;
import app_paciente.view.CalendarView;

public class CalendarController {
    private CalendarModel model;
    private CalendarView view;

    public CalendarController(CalendarModel model, CalendarView view) {
        this.model = model;
        this.view = view;

        // Asignar acciones a los botones
        this.view.getBtnSolicitar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFechasDisponibles();
            }
        });

        this.view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¿Está seguro de cancelar la cita?");
            }
        });

        this.view.getBtnReprogramar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¿Desea reprogramar la cita?");
            }
        });

        // Manejar la selección de días disponibles
        this.view.getListaDiasDisponibles().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !view.getListaDiasDisponibles().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(view, "Esperando confirmación...", "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                view.getListaDiasDisponibles().clearSelection();
            }
        });

        // Llenar el calendario al iniciar
        llenarCalendario();
    }

    /**
     * Llena la tabla del calendario en la vista con los datos generados por el
     * modelo.
     */
    private void llenarCalendario() {
        String[][] calendario = model.generarCalendario();
        String[] columnas = { "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom" };

        // Crear un modelo de tabla con los datos del calendario
        DefaultTableModel tableModel = new DefaultTableModel(calendario, columnas);

        // Asignar el modelo de tabla a la tabla en la vista
        view.getCalendarTable().setModel(tableModel);

        // Personalizar la tabla (opcional)
        view.getCalendarTable().setDefaultRenderer(Object.class, new CalendarRenderer());
        view.getCalendarTable().addMouseListener(new CalendarMouseListener(this));
    }

    /**
     * Muestra las fechas disponibles en la lista de la vista.
     */
    private void mostrarFechasDisponibles() {
        view.getListModel().clear(); // Limpiar la lista actual
        Map<String, String> citasConfirmadas = model.getCitasConfirmadas();
        String[][] calendario = model.generarCalendario();

        // Recorrer el calendario y agregar días disponibles a la lista
        for (int i = 0; i < calendario.length; i++) {
            for (int j = 0; j < calendario[i].length; j++) {
                String fecha = i + "," + j;
                if (!citasConfirmadas.containsKey(fecha) && !calendario[i][j].isEmpty()) {
                    view.getListModel().addElement("Día " + calendario[i][j]);
                }
            }
        }
    }

    public void mostrarDetallesCita(String fecha) {
        Map<String, String> citasConfirmadas = model.getCitasConfirmadas();
        if (citasConfirmadas.containsKey(fecha)) {
            view.getInfoArea().setText("Detalles de la cita:\n" + citasConfirmadas.get(fecha));
            view.getBtnCancelar().setEnabled(true);
            view.getBtnReprogramar().setEnabled(true);
        } else {
            view.getInfoArea().setText("No hay citas registradas en esta fecha.");
            view.getBtnCancelar().setEnabled(false);
            view.getBtnReprogramar().setEnabled(false);
        }
    }
}