package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class PerfilPacienteView extends JPanel {
    private JLabel lblNombre;
    private JLabel lblPeso;
    private JLabel lblEstatura;
    private JLabel lblGrupoSanguineo;
    private JLabel lblAlergias;
    private JLabel lblPadecimientos;
    private JLabel lblMedicamentos;

    public PerfilPacienteView() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblNombre = new JLabel("Nombre: ");
        lblPeso = new JLabel("Peso: ");
        lblEstatura = new JLabel("Estatura: ");
        lblGrupoSanguineo = new JLabel("Grupo Sanguíneo: ");
        lblAlergias = new JLabel("Alergias: ");
        lblPadecimientos = new JLabel("Padecimientos Crónicos: ");
        lblMedicamentos = new JLabel("Medicamentos: ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNombre, gbc);

        gbc.gridy = 1;
        add(lblPeso, gbc);

        gbc.gridy = 2;
        add(lblEstatura, gbc);

        gbc.gridy = 3;
        add(lblGrupoSanguineo, gbc);

        gbc.gridy = 4;
        add(lblAlergias, gbc);

        gbc.gridy = 5;
        add(lblPadecimientos, gbc);

        gbc.gridy = 6;
        add(lblMedicamentos, gbc);
    }

    public void setNombre(String nombre) {
        lblNombre.setText("Nombre: " + nombre);
    }

    public void setPeso(double peso) {
        lblPeso.setText("Peso: " + peso + " kg");
    }

    public void setEstatura(double estatura) {
        lblEstatura.setText("Estatura: " + estatura + " m");
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        lblGrupoSanguineo.setText("Grupo Sanguíneo: " + grupoSanguineo);
    }

    public void setAlergias(String[] alergias) {
        lblAlergias.setText("Alergias: " + String.join(", ", alergias));
    }

    public void setPadecimientosCronicos(String[] padecimientosCronicos) {
        lblPadecimientos.setText("Padecimientos Crónicos: " + String.join(", ", padecimientosCronicos));
    }

    public void setMedicamentosCronicos(String[][] medicamentosCronicos) {
    StringBuilder medicamentosText = new StringBuilder("Medicamentos: ");
    for (int i = 0; i < medicamentosCronicos.length; i++) {
        medicamentosText.append(medicamentosCronicos[i][0]).append(" → ") // Asume que el primer elemento es el nombre del padecimiento
                .append(String.join(", ", medicamentosCronicos[i])).append("; ");
    }
    lblMedicamentos.setText(medicamentosText.toString());
}
}