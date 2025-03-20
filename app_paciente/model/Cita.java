package app_paciente.model;

public class Cita {
    private String fecha;
    private String motivo;
    private String diagnostico;
    private String medicamentosAplicados;
    private String documentosCitas;

    // Getters y Setters
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getMedicamentosAplicados() { return medicamentosAplicados; }
    public void setMedicamentosAplicados(String medicamentosAplicados) { this.medicamentosAplicados = medicamentosAplicados; }

    public String getDocumentosCitas() { return documentosCitas; }
    public void setDocumentosCitas(String documentosCitas) { this.documentosCitas = documentosCitas; }
}