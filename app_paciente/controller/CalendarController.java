package app_paciente.controller;

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
        this.view.getBtnSolicitar().addActionListener(e -> solicitarCita());
        this.view.getBtnCancelar()
                .addActionListener(e -> JOptionPane.showMessageDialog(null, "¿Está seguro de cancelar la cita?"));
        this.view.getBtnReprogramar()
                .addActionListener(e -> JOptionPane.showMessageDialog(null, "¿Desea reprogramar la cita?"));

        // Llenar el calendario al iniciar
        llenarCalendario();

        // Manejar la selección de fechas en el calendario
        view.getCalendarTable().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = view.getCalendarTable().getSelectedRow();
                int col = view.getCalendarTable().getSelectedColumn();
                if (row >= 0 && col >= 0) {
                    String fecha = row + "," + col;
                    mostrarDetallesCita(fecha);
                }
            }
        });

        // Manejar la selección de horas disponibles
        view.getListaHorasDisponibles().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !view.getListaHorasDisponibles().isSelectionEmpty()) {
                String horaSeleccionada = view.getListaHorasDisponibles().getSelectedValue();
                int row = view.getCalendarTable().getSelectedRow();
                int col = view.getCalendarTable().getSelectedColumn();
                if (row >= 0 && col >= 0) {
                    String fecha = row + "," + col;
                    JOptionPane.showMessageDialog(view,
                            "Cita solicitada el día " + fecha + " a las " + horaSeleccionada + ", espere confirmación",
                            "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    view.getListaHorasDisponibles().clearSelection();
                }
            }
        });
    }

    private void llenarCalendario() {
        String[][] calendario = model.generarCalendario();
        String[] columnas = { "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom" };

        // Crear un modelo de tabla con los datos del calendario
        DefaultTableModel tableModel = new DefaultTableModel(calendario, columnas);

        // Asignar el modelo de tabla a la tabla en la vista
        view.getCalendarTable().setModel(tableModel);

        // Personalizar la tabla con el renderizador
        view.getCalendarTable().setDefaultRenderer(Object.class, new CalendarRenderer(model.getCitasConfirmadas()));
    }

    private void mostrarDetallesCita(String fecha) {
        Map<String, String> citasConfirmadas = model.getCitasConfirmadas();
        if (citasConfirmadas.containsKey(fecha)) {
            // Mostrar información de la cita y habilitar botones
            view.getInfoArea().setText("Detalles de la cita:\n" + citasConfirmadas.get(fecha));
            view.getBtnCancelar().setEnabled(true);
            view.getBtnReprogramar().setEnabled(true);
            view.getBtnSolicitar().setEnabled(false); // Desactivar botón de solicitar
            view.getListModelHoras().clear(); // Limpiar lista de horas
        } else {
            // Mostrar lista de horas disponibles y habilitar botón de solicitar
            view.getInfoArea().setText("No hay citas registradas en esta fecha.");
            view.getBtnCancelar().setEnabled(false);
            view.getBtnReprogramar().setEnabled(false);
            view.getBtnSolicitar().setEnabled(true);

            // Simular horas disponibles (puedes obtenerlas de una base de datos o servicio)
            view.getListModelHoras().clear();
            view.getListModelHoras().addElement("10:00 AM");
            view.getListModelHoras().addElement("12:00 PM");
            view.getListModelHoras().addElement("2:00 PM");
        }
    }

    private void solicitarCita() {
        int row = view.getCalendarTable().getSelectedRow();
        int col = view.getCalendarTable().getSelectedColumn();
        if (row >= 0 && col >= 0) {
            String fecha = row + "," + col;
            JOptionPane.showMessageDialog(null, "Cita solicitada para el día " + fecha);
        }
    }
}