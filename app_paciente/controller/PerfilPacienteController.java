package app_paciente.controller;

import app_paciente.model.Paciente;
import app_paciente.view.PerfilPacienteView;

public class PerfilPacienteController {
    private PerfilPacienteView view;
    private Paciente model;

    public PerfilPacienteController(PerfilPacienteView view, Paciente model) {
        this.view = view;
        this.model = model;
        model.inicializarDatosPrueba();

        view.setNombre(model.getNombre());
        view.setPeso(model.getPeso());
        view.setEstatura(model.getEstatura());
        view.setGrupoSanguineo(model.getGrupoSanguineo());
        view.setAlergias(model.getAlergias());
        view.setPadecimientosCronicos(model.getPadecimientosCronicos());
        view.setMedicamentosCronicos(model.getMedicamentosCronicos());
    }
}