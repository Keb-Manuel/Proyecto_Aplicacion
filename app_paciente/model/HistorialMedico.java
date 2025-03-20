package app_paciente.model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<Cita> citas;

    public HistorialMedico() {
        citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> getCitas() {
        return citas;
    }
}