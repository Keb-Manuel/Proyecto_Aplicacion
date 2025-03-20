package app_paciente.model;

public class Paciente {
    private String nombre;
    private double peso;
    private double estatura;
    private String grupoSanguineo;
    private String[] alergias;
    private String[] padecimientosCronicos;
    private String[][] medicamentosCronicos;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public String getGrupoSanguineo() { return grupoSanguineo; }
    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }

    public String[] getAlergias() { return alergias; }
    public void setAlergias(String[] alergias) { this.alergias = alergias; }

    public String[] getPadecimientosCronicos() { return padecimientosCronicos; }
    public void setPadecimientosCronicos(String[] padecimientosCronicos) { this.padecimientosCronicos = padecimientosCronicos; }

    public String[][] getMedicamentosCronicos() { return medicamentosCronicos; }
    public void setMedicamentosCronicos(String[][] medicamentosCronicos) { this.medicamentosCronicos = medicamentosCronicos; }

    public void inicializarDatosPrueba() {
        this.nombre = "Juan Pérez";
        this.peso = 70.5;
        this.estatura = 1.75;
        this.grupoSanguineo = "O+";
        this.alergias = new String[] { "Polen", "Mariscos" };
        this.padecimientosCronicos = new String[] { "Hipertensión", "Diabetes" };
        this.medicamentosCronicos = new String[][] {
            { "Hipertensión", "Losartán", "50 mg" },
            { "Diabetes", "Metformina", "500 mg" }
        };
    }
}