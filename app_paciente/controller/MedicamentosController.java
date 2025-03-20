package app_paciente.controller;

import app_paciente.model.Medicamento;
import app_paciente.view.MedicamentosView;

public class MedicamentosController {
    private MedicamentosView view;
    private Medicamento[] medicamentos;

    public MedicamentosController(MedicamentosView view, Medicamento[] medicamentos) {
        this.view = view;
        this.medicamentos = medicamentos;

        for (Medicamento medicamento : medicamentos) {
            view.agregarMedicamento(medicamento.getNombre(), medicamento.getDosis());
        }
    }
}