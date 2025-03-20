package app_paciente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import app_paciente.model.CalendarModel;
import app_paciente.model.Paciente;
import app_paciente.view.CalendarView;
import app_paciente.view.ChatView;
import app_paciente.view.ConfiguracionesView;
import app_paciente.view.ContainerGenBaseView;
import app_paciente.view.HistorialMedicoView;
import app_paciente.view.MedicamentosView;
import app_paciente.view.PerfilPacienteView;
import app_paciente.view.RecomendacionesView;

public class ContainerGenBaseController implements ActionListener {
    private ContainerGenBaseView view;

    public ContainerGenBaseController(ContainerGenBaseView view) {
        this.view = view;
        for (JButton btn : view.getBotones()) {
            btn.addActionListener(this);
        }
    }

    private void cambiarPanel(JPanel nuevoPanel) {
        System.out.println("Cambio de pantalla a: " + nuevoPanel.getClass().getSimpleName());
        view.setPanelCentral(nuevoPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("chat")) {
            cambiarPanel(new ChatView());
        } else if (comando.equals("perfil")) {
            // Crear el modelo y la vista del perfil
            Paciente paciente = new Paciente();
            PerfilPacienteView perfilView = new PerfilPacienteView();
            new PerfilPacienteController(perfilView, paciente); // Conectar controlador
            cambiarPanel(perfilView); // Cambiar al panel del perfil
        } else if (comando.equals("hist_medico")) {
            cambiarPanel(new HistorialMedicoView());
        } else if (comando.equals("medicamentos")) {
            cambiarPanel(new MedicamentosView());
        } else if (comando.equals("recomendaciones")) {
            cambiarPanel(new RecomendacionesView());
        } else if (comando.equals("agenda")) {
            CalendarModel model = new CalendarModel();
            CalendarView calendarView = new CalendarView();
            new CalendarController(model, calendarView); // Conectar controlador
            cambiarPanel(calendarView); // Cambiar al panel del calendario

        } else if (comando.equals("configuracion")) {
            cambiarPanel(new ConfiguracionesView());
        }
    }
}