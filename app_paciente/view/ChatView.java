package app_paciente.view;

import javax.swing.*;
import java.awt.*;

public class ChatView extends JPanel {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton btnEnviar;

    public ChatView() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new BorderLayout());

        inputField = new JTextField();
        btnEnviar = new JButton("Enviar");

        panelInput.add(inputField, BorderLayout.CENTER);
        panelInput.add(btnEnviar, BorderLayout.EAST);

        add(panelInput, BorderLayout.SOUTH);
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public String getMensaje() {
        return inputField.getText();
    }

    public void agregarMensaje(String mensaje) {
        chatArea.append(mensaje + "\n");
    }
}