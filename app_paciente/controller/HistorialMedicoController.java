package app_paciente.controller;

import app_paciente.model.Cita;
import app_paciente.model.HistorialMedico;
import app_paciente.view.HistorialMedicoView;

public class HistorialMedicoController {
    private HistorialMedicoView view;
    private HistorialMedico model;

    public HistorialMedicoController(HistorialMedicoView view, HistorialMedico model) {
        this.view = view;
        this.model = model;

        for (Cita cita : model.getCitas()) {
            view.agregarCita(cita.getFecha() + " - " + cita.getMotivo());
        }
    }
}